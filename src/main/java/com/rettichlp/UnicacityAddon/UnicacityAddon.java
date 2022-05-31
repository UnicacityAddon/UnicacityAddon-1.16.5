package com.rettichlp.UnicacityAddon;

import com.google.gson.JsonObject;
import com.rettichlp.UnicacityAddon.base.abstraction.AbstractionLayer;
import com.rettichlp.UnicacityAddon.base.command.CommandHandler;
import com.rettichlp.UnicacityAddon.base.text.ColorCode;
import com.rettichlp.UnicacityAddon.base.text.Message;
import net.labymod.api.LabyModAddon;
import net.labymod.main.LabyMod;
import net.labymod.settings.elements.HeaderElement;
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
    }

    @Override public void loadConfig() {
        CONFIG = getConfig();
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

        /*
        // jobs
        list.add(new HeaderElement(Message.getBuilder()
                .of("Jobs").color(ColorCode.WHITE).bold().advance()
                .create()));

        list.add(new BooleanElement("Auto /dropammo",
                this,
                new ControlElement.IconData(Material.ARROW),
                "command.jobs.dropammo",
                AbstractionLayer.getConfig().getCommandJobsDropammo()));

        list.add(new BooleanElement("Automatisch /droptransport",
                this,
                new ControlElement.IconData(Material.CHEST),
                "command.jobs.droptransport",
                AbstractionLayer.getConfig().getCommandJobsDroptransport()));

        list.add(new BooleanElement("Auto /dropwaste",
                this,
                new ControlElement.IconData(Material.CAULDRON),
                "command.jobs.dropwaste",
                AbstractionLayer.getConfig().getCommandJobsDropwaste()));

        // factions
        list.add(new HeaderElement(Message.getBuilder()
                .of("Fraktionen").color(ColorCode.WHITE).bold().advance()
                .create()));

        list.add(new BooleanElement("Toggle1",
                this,
                new ControlElement.IconData(Material.CAULDRON),
                "config.factions.toggle1",
                UnicacityAddonConfig.factions_toggle1));

        // any
        list.add(new HeaderElement(Message.getBuilder()
                .of("").color(ColorCode.WHITE).bold().advance()
                .create()));

        list.add(new BooleanElement("Tankwarnung",
                this,
                new ControlElement.IconData(Material.BUCKET),
                "config.car.tankWarning",
                AbstractionLayer.getConfig().getEventCarTankWarning()));


        BooleanElement jobs = new BooleanElement("Jobs",
                this,
                new ControlElement.IconData(Material.FISHING_ROD),
                "config.job",
                true);
        jobs.setSubSettings(jobSettings);
        list.add(jobs);

        BooleanElement faction = new BooleanElement("Fraktion",
                this,
                new ControlElement.IconData(Material.FISHING_ROD),
                "config.faction",
                true);
        faction.setSubSettings(factionSettings);
        list.add(faction);
        */
    }
}
