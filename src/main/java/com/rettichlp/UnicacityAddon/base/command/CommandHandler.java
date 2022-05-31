package com.rettichlp.UnicacityAddon.base.command;

import com.rettichlp.UnicacityAddon.UnicacityAddon;
import com.rettichlp.UnicacityAddon.base.abstraction.AbstractionLayer;
import com.rettichlp.UnicacityAddon.base.abstraction.UPlayer;
import com.rettichlp.UnicacityAddon.base.text.ColorCode;
import com.rettichlp.UnicacityAddon.base.text.Message;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.events.client.chat.MessageSendEvent;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author RettichLP
 */
public class CommandHandler {

    @Subscribe
    public void onMessage(MessageSendEvent e) {
        String msg = e.getMessage();
        if (!msg.startsWith("/")) return;
        e.setCancelled(true);

        String label = msg.split(" ")[0].substring(1);
        String[] args = msg.substring(label.length() + 2).split(" ");

        try {
            Map<String, Class<?>> commandMap = getCommandMap();
            if (!commandMap.containsKey(label)) return;

            Class<?> commandClass = commandMap.get(label);
            Method commandMethod = commandClass.getDeclaredMethod("onCommand", UPlayer.class, String[].class);

            Object commandClassInstance = commandClass.newInstance();
            boolean success = (boolean) commandMethod.invoke(commandClassInstance, AbstractionLayer.getPlayer(), args);

            if (!success) {
                Message.getBuilder()
                        .error()
                        .space()
                        .of(commandMethod.getAnnotation(Command.class).usage().replace("%label%", label)).color(ColorCode.GRAY).advance()
                        .sendTo(AbstractionLayer.getPlayer().getPlayer());
                UnicacityAddon.LOGGER.warning("Syntax error in executed command: " + label + " by: "  + AbstractionLayer.getPlayer().getName());
            } else
                UnicacityAddon.LOGGER.info("Successfully executed command: " + label + " by: "  + AbstractionLayer.getPlayer().getName());

        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException ex) {
            UnicacityAddon.LOGGER.severe("Error in CommandHandler during execution: " + label);
            throw new RuntimeException(ex);
        }
    }

    private Map<String, Class<?>> getCommandMap() {
        Map<String, Class<?>> commandMap = new HashMap<>();

        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forPackage("com.rettichlp.UnicacityAddon"))
                .setScanners(Scanners.MethodsAnnotated);

        Reflections reflections = new Reflections(configurationBuilder);

        reflections.getMethodsAnnotatedWith(Command.class).forEach(method -> {
            Command commandAnnotation = method.getAnnotation(Command.class);

            for (int i = 0; i < commandAnnotation.value().length; i++) {
                commandMap.put(commandAnnotation.value()[i], method.getDeclaringClass());
            }

        });

        return commandMap;
    }
}