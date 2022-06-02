package com.rettichlp.UnicacityAddon;

import com.google.gson.JsonObject;
import com.rettichlp.UnicacityAddon.base.abstraction.AbstractionLayer;
import com.rettichlp.UnicacityAddon.base.command.CommandHandler;
import com.rettichlp.UnicacityAddon.base.config.ConfigElements;
import com.rettichlp.UnicacityAddon.base.faction.FactionHandler;
import com.rettichlp.UnicacityAddon.base.text.ColorCode;
import com.rettichlp.UnicacityAddon.base.text.Message;
import com.rettichlp.UnicacityAddon.events.NameTagEventHandler;
import net.labymod.api.LabyModAddon;
import net.labymod.main.LabyMod;
import net.labymod.settings.elements.BooleanElement;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.HeaderElement;
import net.labymod.settings.elements.SettingsElement;
import net.labymod.utils.Material;
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

        list.add(new HeaderElement(Message.getBuilder()
                .of("U").color(ColorCode.RED).bold().advance()
                .of("nica").color(ColorCode.BLUE).bold().advance()
                .of("C").color(ColorCode.RED).bold().advance()
                .of("ity").color(ColorCode.BLUE).bold().advance()
                .of("A").color(ColorCode.RED).bold().advance()
                .of("ddon").color(ColorCode.BLUE).bold().advance()
                .space()
                .of("v" + VERSION).color(ColorCode.BLUE).bold().advance()
                .space()
                .of("-").color(ColorCode.GRAY).bold().advance()
                .space()
                .of("by RettichLP").color(ColorCode.GOLD).advance()
                .create()));

        BooleanElement nameTagForFactionSuffix = new BooleanElement("Fraktionssuffix", this, new ControlElement.IconData(Material.NAME_TAG), "NAMETAG_FACTIONSUFFIX",
                ConfigElements.NAMETAG_FACTIONSUFFIX);
        list.add(nameTagForFactionSuffix);

        BooleanElement nameTagForFaction = new BooleanElement("Fraktionsmarkierung", this, new ControlElement.IconData(Material.BLUE_DYE), "NAMETAG_FACTION",
                ConfigElements.NAMETAG_FACTION);
        list.add(nameTagForFaction);

        BooleanElement nameTagForAlliance = new BooleanElement("Bündnismarkierung", this, new ControlElement.IconData(Material.PINK_DYE), "NAMETAG_ALLIANCE",
                ConfigElements.NAMETAG_ALLIANCE);
        nameTagForAlliance.setSubSettings(ConfigElements.getNameTagForAlliance());
        list.add(nameTagForAlliance);

        BooleanElement nameTagForStreetwar = new BooleanElement("Streetwarmarkierung", this, new ControlElement.IconData(Material.IRON_SWORD), "NAMETAG_STREETWAR",
                ConfigElements.NAMETAG_STREETWAR);
        nameTagForStreetwar.setSubSettings(ConfigElements.getNameTagForStreetwar());
        list.add(nameTagForStreetwar);

        BooleanElement nameTagForHouseBan = new BooleanElement("Hausverbot", this, new ControlElement.IconData(Material.SPAWNER), "NAMETAG_HOUSEBAN",
                ConfigElements.NAMETAG_HOUSEBAN);
        list.add(nameTagForHouseBan);
    }
}
