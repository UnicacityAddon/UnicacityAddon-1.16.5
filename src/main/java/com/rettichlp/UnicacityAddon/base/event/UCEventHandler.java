package com.rettichlp.UnicacityAddon.base.event;

import com.rettichlp.UnicacityAddon.UnicacityAddon;
import com.rettichlp.UnicacityAddon.base.abstraction.AbstractionLayer;
import com.rettichlp.UnicacityAddon.base.logger.LoggerAPI;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;

import java.util.Set;

import static org.reflections.scanners.Scanners.TypesAnnotated;

/**
 * @author RettichLP
 */
public class UCEventHandler {

    public static void registerEvents() {
        Reflections reflections = new Reflections(UnicacityAddon.class.getPackage().getName(), Scanners.values());
        Set<Class<?>> events = reflections.get(TypesAnnotated.with(UCEvent.class).asClass());

        events.forEach(clazz -> {
            try {
                AbstractionLayer.getLabymod().getEventService().registerListener(clazz.newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                LoggerAPI.error(e.getCause().getMessage(), UCEventHandler.class);
                throw new RuntimeException(e);
            }
        });
    }
}