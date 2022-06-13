package com.rettichlp.UnicacityAddon.base.command;

import com.rettichlp.UnicacityAddon.UnicacityAddon;
import com.rettichlp.UnicacityAddon.base.abstraction.AbstractionLayer;
import com.rettichlp.UnicacityAddon.base.event.UCEvent;
import com.rettichlp.UnicacityAddon.base.logger.LoggerAPI;
import com.rettichlp.UnicacityAddon.base.text.ColorCode;
import com.rettichlp.UnicacityAddon.base.text.Message;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.events.client.chat.MessageSendEvent;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.reflections.scanners.Scanners.MethodsAnnotated;

/**
 * @author RettichLP
 */
@UCEvent
public class UCCommandHandler {

    @Subscribe
    public void onMessageSend(MessageSendEvent e) {
        String msg = e.getMessage();
        if (!msg.startsWith("/")) return;

        String label = msg.substring(1);
        List<String> args = new ArrayList<>();

        if (msg.contains(" ")) {
            label = msg.split(" ")[0].substring(1);
            args = Arrays.asList(msg.substring(label.length() + 2).split(" "));
        }

        Map<String, Method> commandMap = getCommandMap();
        if (!commandMap.containsKey(label)) return;
        e.setCancelled(true);

        Method method = commandMap.get(label);
        Class<?> clazz = method.getDeclaringClass();

        try {
            Object commandClassInstance = clazz.newInstance();
            boolean success = (boolean) method.invoke(commandClassInstance, AbstractionLayer.getPlayer(), args);

            if (!success) Message.getBuilder()
                    .error()
                    .space()
                    .of("Syntax: " + method.getAnnotation(UCCommand.class).usage().replace("%label%", label)).color(ColorCode.GRAY).advance()
                    .sendTo(AbstractionLayer.getPlayer().getPlayer());

            LoggerAPI.command(label, args, success);

        } catch (InvocationTargetException ex) {
            LoggerAPI.error(ex.getCause().getMessage(), clazz);
            throw new RuntimeException(ex);
        } catch (InstantiationException | IllegalAccessException ex) {
            LoggerAPI.error(ex.getCause().getMessage(), this.getClass());
            throw new RuntimeException(ex);
        }
    }

    private Map<String, Method> getCommandMap() {
        Map<String, Method> commandMap = new HashMap<>();

        Reflections reflections = new Reflections(UnicacityAddon.class.getPackage().getName(), Scanners.values());
        reflections.get(MethodsAnnotated.with(UCCommand.class).as(Method.class)).forEach(method -> {
            UCCommand ucCommand = method.getAnnotation(UCCommand.class);
            System.out.println(Arrays.toString(ucCommand.value()));

            for (int i = 0; i < ucCommand.value().length; i++) {
                commandMap.put(ucCommand.value()[i], method);
            }
        });

        return commandMap;
    }
}