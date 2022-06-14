package com.rettichlp.UnicacityAddon;

import com.rettichlp.UnicacityAddon.base.abstraction.AbstractionLayer;
import com.rettichlp.UnicacityAddon.base.command.UCCommandHandler;
import com.rettichlp.UnicacityAddon.base.config.ConfigSettings;
import com.rettichlp.UnicacityAddon.base.faction.FactionHandler;
import com.rettichlp.UnicacityAddon.base.module.UCModuleHandler;
import com.rettichlp.UnicacityAddon.events.ATMInfoEventHandler;
import com.rettichlp.UnicacityAddon.events.BombTimerEventHandler;
import com.rettichlp.UnicacityAddon.events.NameTagEventHandler;
import com.rettichlp.UnicacityAddon.modules.BombTimerModule;
import net.labymod.api.LabyModAddon;
import net.labymod.ingamegui.ModuleCategoryRegistry;
import net.labymod.settings.elements.SettingsElement;

import java.util.List;

/**
 * @author RettichLP
 */
public class UnicacityAddon extends LabyModAddon {

    public static final String VERSION = "1.0.0-beta";
    public static UnicacityAddon ADDON;

    @Override
    public void onEnable() {
        ADDON = this;

        // UCEventHandler.registerEvents();
        AbstractionLayer.getLabymod().getEventService().registerListener(new UCCommandHandler());
        AbstractionLayer.getLabymod().getEventService().registerListener(new ATMInfoEventHandler());
        AbstractionLayer.getLabymod().getEventService().registerListener(new BombTimerEventHandler());
        AbstractionLayer.getLabymod().getEventService().registerListener(new NameTagEventHandler());

        //UCModuleHandler.registerModules();
        ModuleCategoryRegistry.loadCategory(UCModuleHandler.UNICACITY);
        AbstractionLayer.getLabymod().getApi().registerModule(new BombTimerModule());
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