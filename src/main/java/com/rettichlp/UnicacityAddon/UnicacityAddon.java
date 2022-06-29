package com.rettichlp.UnicacityAddon;

import com.rettichlp.UnicacityAddon.base.abstraction.AbstractionLayer;
import com.rettichlp.UnicacityAddon.base.command.UCCommandHandler;
import com.rettichlp.UnicacityAddon.base.config.ConfigSettings;
import com.rettichlp.UnicacityAddon.base.event.UCEventHandler;
import com.rettichlp.UnicacityAddon.base.faction.FactionHandler;
import com.rettichlp.UnicacityAddon.base.module.UCModuleHandler;
import net.labymod.api.LabyModAddon;
import net.labymod.ingamegui.ModuleCategoryRegistry;
import net.labymod.settings.elements.SettingsElement;

import java.util.List;

/**
 * @author RettichLP
 */
public class UnicacityAddon extends LabyModAddon {

    public static final String VERSION = "1.0.0-beta.2";
    public static UnicacityAddon ADDON;

    @Override
    public void onEnable() {
        ADDON = this;

        ModuleCategoryRegistry.loadCategory(UCModuleHandler.UNICACITY);
        UCModuleHandler.registerModules();
        UCEventHandler.registerEvents();
        AbstractionLayer.getLabymod().getEventService().registerListener(new UCCommandHandler());
    }

    @Override
    public void loadConfig() {
        FactionHandler.getPlayerFactionMap();
        FactionHandler.getPlayerRankMap();
    }

    @Override
    protected void fillSettings(List<SettingsElement> list) {
        ConfigSettings.createConfig(this, list);
    }
}