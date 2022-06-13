package com.rettichlp.UnicacityAddon.base.module;

import com.rettichlp.UnicacityAddon.UnicacityAddon;
import com.rettichlp.UnicacityAddon.base.abstraction.AbstractionLayer;
import com.rettichlp.UnicacityAddon.base.event.UCEvent;
import com.rettichlp.UnicacityAddon.base.logger.LoggerAPI;
import net.labymod.ingamegui.Module;
import net.labymod.ingamegui.ModuleCategory;
import net.labymod.settings.elements.ControlElement;
import net.labymod.utils.Material;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;

import java.util.Set;

import static org.reflections.scanners.Scanners.TypesAnnotated;

/**
 * @author RettichLP
 */
public class UCModuleHandler {

    public static final ModuleCategory UNICACITY = new ModuleCategory("Unicacity", true, new ControlElement.IconData(Material.DIAMOND));

    public static void registerModules() {
        Reflections reflections = new Reflections(UnicacityAddon.class.getPackage().getName(), Scanners.values());
        Set<Class<?>> events = reflections.get(TypesAnnotated.with(UCModule.class).asClass());

        events.forEach(clazz -> {
            try {
                AbstractionLayer.getLabymod().getApi().registerModule((Module) clazz.newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                LoggerAPI.error(e.getCause().getMessage(), UCModuleHandler.class);
                throw new RuntimeException(e);
            }
        });
    }
}