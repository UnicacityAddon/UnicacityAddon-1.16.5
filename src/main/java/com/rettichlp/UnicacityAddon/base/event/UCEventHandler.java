package com.rettichlp.UnicacityAddon.base.event;

import com.rettichlp.UnicacityAddon.base.abstraction.AbstractionLayer;
import com.rettichlp.UnicacityAddon.base.reflection.ReflectionUtils;

/**
 * @author RettichLP
 */
public class UCEventHandler {

    public static void registerEvents() {
        ReflectionUtils.getClassesAnnotatedWith(UCEvent.class, "com.rettichlp.UnicacityAddon.events").forEach(clazz -> {
            try {
                AbstractionLayer.getLabymod().getEventService().registerListener(clazz.newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
    }
}