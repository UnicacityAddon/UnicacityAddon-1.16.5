package com.rettichlp.UnicacityAddon;

import com.google.gson.JsonObject;
import com.rettichlp.UnicacityAddon.base.abstraction.AbstractionLayer;
import com.rettichlp.UnicacityAddon.base.command.CommandHandler;
import com.rettichlp.UnicacityAddon.base.config.ConfigSettings;
import com.rettichlp.UnicacityAddon.base.faction.FactionHandler;
import com.rettichlp.UnicacityAddon.events.NameTagEventHandler;
import net.labymod.api.LabyModAddon;
import net.labymod.main.LabyMod;
import net.labymod.settings.elements.SettingsElement;
import net.minecraft.client.Minecraft;

import java.util.List;
import java.util.logging.Logger;

/**
 * @author RettichLP
 */
public class UnicacityAddon extends LabyModAddon {

    public static final String VERSION = "1.0.0";
    public static Logger LOGGER = Logger.getLogger("UnicacityAddon");
    public static JsonObject CONFIG;
    public static final LabyMod LABYMOD = LabyMod.getInstance();
    public static final Minecraft MINECRAFT = Minecraft.getInstance();

    @Override
    public void onEnable() {
        // CommandHandler
        AbstractionLayer.getLabymod().getEventService().registerListener(new CommandHandler());

        // Events
        AbstractionLayer.getLabymod().getEventService().registerListener(new NameTagEventHandler());
    }

    @Override
    public void loadConfig() {
        CONFIG = getConfig();
        FactionHandler.getPlayerFactionMap();
        FactionHandler.getPlayerRankMap();
    }

    @Override
    protected void fillSettings(List<SettingsElement> list) {
        ConfigSettings.createConfig(this, list);
    }
}
