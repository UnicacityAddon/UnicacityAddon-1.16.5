package com.rettichlp.UnicacityAddon.base.module;

import com.rettichlp.UnicacityAddon.base.abstraction.AbstractionLayer;
import com.rettichlp.UnicacityAddon.base.reflection.ReflectionUtils;
import net.labymod.ingamegui.Module;
import net.labymod.ingamegui.ModuleCategory;
import net.labymod.settings.elements.ControlElement;
import net.labymod.utils.Material;

/**
 * @author RettichLP
 */
public class UCModuleHandler {

    public static final ModuleCategory UNICACITY = new ModuleCategory("Unicacity", true, new ControlElement.IconData(Material.DIAMOND));

    public static void registerModules() {
        ReflectionUtils.getClassesAnnotatedWith(UCModule.class, "com.rettichlp.UnicacityAddon.modules").forEach(clazz -> {
            try {
                AbstractionLayer.getLabymod().getApi().registerModule((Module) clazz.newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
    }
}