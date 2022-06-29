package com.rettichlp.UnicacityAddon.base.command;

import com.rettichlp.UnicacityAddon.base.abstraction.AbstractionLayer;
import com.rettichlp.UnicacityAddon.base.event.UCEvent;
import com.rettichlp.UnicacityAddon.base.reflection.ReflectionUtils;
import com.rettichlp.UnicacityAddon.base.text.ColorCode;
import com.rettichlp.UnicacityAddon.base.text.Message;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.events.client.chat.MessageSendEvent;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        } catch (InvocationTargetException ex) {
            ex.getCause().printStackTrace();
            throw new RuntimeException(ex);
        } catch (InstantiationException | IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }
    }

    private Map<String, Method> getCommandMap() {
        Map<String, Method> commandMap = new HashMap<>();

        ReflectionUtils.getMethodsAnnotatedWith(UCCommand.class, "com.rettichlp.UnicacityAddon.commands").forEach(method -> {
            UCCommand ucCommand = method.getAnnotation(UCCommand.class);
            for (int i = 0; i < ucCommand.value().length; i++) {
                commandMap.put(ucCommand.value()[i], method);
            }
        });

        return commandMap;
    }
}