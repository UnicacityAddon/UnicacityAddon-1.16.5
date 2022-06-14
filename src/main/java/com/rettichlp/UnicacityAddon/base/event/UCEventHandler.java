package com.rettichlp.UnicacityAddon.base.event;

import com.rettichlp.UnicacityAddon.base.abstraction.AbstractionLayer;
import com.rettichlp.UnicacityAddon.base.reflection.ReflectionUtils;

/**
 * @author RettichLP
 */
public class UCEventHandler {

    public static void registerEvents() {
        ReflectionUtils reflectionUtils = new ReflectionUtils("com.rettichlp.UnicacityAddon.events");
        reflectionUtils.getClassesAnnotatedWith(UCEvent.class).forEach(clazz -> {
            try {
                AbstractionLayer.getLabymod().getEventService().registerListener(clazz.newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
    }
}