package com.rettichlp.UnicacityAddon.base.config;

import com.rettichlp.UnicacityAddon.UnicacityAddon;
import com.rettichlp.UnicacityAddon.base.faction.Faction;
import com.rettichlp.UnicacityAddon.base.text.ColorCode;
import com.rettichlp.UnicacityAddon.base.text.Message;
import net.labymod.gui.elements.ColorPicker;
import net.labymod.gui.elements.DropDownMenu;
import net.labymod.main.LabyMod;
import net.labymod.settings.Settings;
import net.labymod.settings.elements.BooleanElement;
import net.labymod.settings.elements.ColorPickerCheckBoxBulkElement;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.DropDownElement;
import net.labymod.settings.elements.HeaderElement;
import net.labymod.settings.elements.SettingsElement;
import net.labymod.utils.Consumer;
import net.labymod.utils.Material;
import net.labymod.utils.ModColor;
import net.minecraft.world.BossInfo;

import java.awt.*;
import java.util.List;

public class ConfigSettings {

    public static void createConfig(UnicacityAddon unicacityAddon, List<SettingsElement> list) {
        list.add(new HeaderElement(Message.getBuilder()
                .of("U").color(ColorCode.RED).bold().advance()
                .of("nica").color(ColorCode.BLUE).bold().advance()
                .of("C").color(ColorCode.RED).bold().advance()
                .of("ity").color(ColorCode.BLUE).bold().advance()
                .of("A").color(ColorCode.RED).bold().advance()
                .of("ddon").color(ColorCode.BLUE).bold().advance()
                .space()
                .of("v" + UnicacityAddon.VERSION).color(ColorCode.BLUE).bold().advance()
                .space()
                .of("-").color(ColorCode.GRAY).bold().advance()
                .space()
                .of("by RettichLP").color(ColorCode.GOLD).advance()
                .create()));

        list.add(new HeaderElement(Message.getBuilder()
                .of("Einstellungen").color(ColorCode.WHITE).advance()
                .create()));

        BooleanElement nametagFactionSuffix = new BooleanElement("Fraktionsinfo", unicacityAddon, new ControlElement.IconData(Material.NAME_TAG), "NAMETAG_FACTIONSUFFIX",
                ConfigElements.getNametagFactionSuffix());
        list.add(nametagFactionSuffix);

        BooleanElement nameTagFaction = new BooleanElement("Fraktion", unicacityAddon, new ControlElement.IconData(Material.BLUE_DYE), "NAMETAG_FACTION",
                ConfigElements.getNametagFaction());
        nameTagFaction.setSubSettings(nameTagFactionSettings());
        list.add(nameTagFaction);

        BooleanElement nameTagAlliance = new BooleanElement("Bündnis", unicacityAddon, new ControlElement.IconData(Material.PURPLE_DYE), "NAMETAG_ALLIANCE",
                ConfigElements.getNametagAlliance());
        nameTagAlliance.setSubSettings(nameTagAllianceSettings());
        list.add(nameTagAlliance);

        BooleanElement nameTagStreetwar = new BooleanElement("Streetwar", unicacityAddon, new ControlElement.IconData(Material.DIAMOND_HORSE_ARMOR), "NAMETAG_STREETWAR",
                ConfigElements.getNametagStreetwar());
        nameTagStreetwar.setSubSettings(nameTagStreetwarSettings());
        list.add(nameTagStreetwar);

        BooleanElement nameTagForHouseBan = new BooleanElement("Hausverbot", unicacityAddon, new ControlElement.IconData(Material.SPAWNER), "NAMETAG_HOUSEBAN",
                ConfigElements.getNametagHouseban());
        list.add(nameTagForHouseBan);
    }

    private static Settings nameTagAllianceSettings() {
        Settings settings = new Settings();

        DropDownMenu<ColorCode> dropDownMenu0 = new DropDownMenu<ColorCode>("Farbe", 0, 0, 0, 0).fill(ColorCode.values());
        dropDownMenu0.setSelected(ConfigElements.getNametagAllianceColor());
        dropDownMenu0.setEntryDrawer((object, matrixStack, x, y, string) -> LabyMod.getInstance().getDrawUtils()
                .drawString(matrixStack, ColorCode.valueOf(object.toString().toUpperCase()).toString(), x, y));
        DropDownElement<ColorCode> dropDownElement0 = new DropDownElement<>("", dropDownMenu0);
        dropDownElement0.setChangeListener(ConfigElements::setNametagAllianceColor);

        DropDownMenu<Faction> dropDownMenu1 = new DropDownMenu<Faction>("Bündnisfraktion 1", 0, 0, 0, 0).fill(Faction.values());
        dropDownMenu1.setSelected(ConfigElements.getNametagAlliance1());
        dropDownMenu1.setEntryDrawer((object, matrixStack, x, y, string) -> LabyMod.getInstance().getDrawUtils()
                .drawString(matrixStack, Faction.valueOf(object.toString().toUpperCase()).getDisplayName(), x, y));
        DropDownElement<Faction> dropDownElement1 = new DropDownElement<>("", dropDownMenu1);
        dropDownElement1.setChangeListener(ConfigElements::setNametagAlliance1);

        DropDownMenu<Faction> dropDownMenu2 = new DropDownMenu<Faction>("Bündnisfraktion 2 (optional)", 0, 0, 0, 0).fill(Faction.values());
        dropDownMenu2.setSelected(ConfigElements.getNametagAlliance2());
        dropDownMenu2.setEntryDrawer((object, matrixStack, x, y, string) -> LabyMod.getInstance().getDrawUtils()
                .drawString(matrixStack, Faction.valueOf(object.toString().toUpperCase()).getDisplayName(), x, y));
        DropDownElement<Faction> dropDownElement2 = new DropDownElement<>("", dropDownMenu2);
        dropDownElement2.setChangeListener(ConfigElements::setNametagAlliance2);

        settings.add(dropDownElement0);
        settings.add(dropDownElement1);
        settings.add(dropDownElement2);
        return settings;
    }

    private static Settings nameTagFactionSettings() {
        Settings settings = new Settings();

        DropDownMenu<ColorCode> dropDownMenu0 = new DropDownMenu<ColorCode>("Farbe", 0, 0, 0, 0).fill(ColorCode.values());
        dropDownMenu0.setSelected(ConfigElements.getNametagFactionColor());
        dropDownMenu0.setEntryDrawer((object, matrixStack, x, y, string) -> LabyMod.getInstance().getDrawUtils()
                .drawString(matrixStack, ColorCode.valueOf(object.toString().toUpperCase()).toString(), x, y));
        DropDownElement<ColorCode> dropDownElement0 = new DropDownElement<>("", dropDownMenu0);
        dropDownElement0.setChangeListener(ConfigElements::setNametagFactionColor);

        settings.add(dropDownElement0);
        return settings;
    }

    private static Settings nameTagStreetwarSettings() {
        Settings settings = new Settings();

        DropDownMenu<ColorCode> dropDownMenu0 = new DropDownMenu<ColorCode>("Farbe", 0, 0, 0, 0).fill(ColorCode.values());
        dropDownMenu0.setSelected(ConfigElements.getNametagStreetwarColor());
        dropDownMenu0.setEntryDrawer((object, matrixStack, x, y, string) -> LabyMod.getInstance().getDrawUtils()
                .drawString(matrixStack, ColorCode.valueOf(object.toString().toUpperCase()).toString(), x, y));
        DropDownElement<ColorCode> dropDownElement0 = new DropDownElement<>("", dropDownMenu0);
        dropDownElement0.setChangeListener(ConfigElements::setNametagStreetwarColor);

        DropDownMenu<Faction> dropDownMenu1 = new DropDownMenu<Faction>("Streetwarfraktion 1", 0, 0, 0, 0).fill(Faction.values());
        dropDownMenu1.setSelected(ConfigElements.getNametagStreetwar1());
        dropDownMenu1.setEntryDrawer((object, matrixStack, x, y, string) -> LabyMod.getInstance().getDrawUtils()
                .drawString(matrixStack, Faction.valueOf(object.toString().toUpperCase()).getDisplayName(), x, y));
        DropDownElement<Faction> dropDownElement1 = new DropDownElement<>("", dropDownMenu1);
        dropDownElement1.setChangeListener(ConfigElements::setNametagStreetwar1);

        DropDownMenu<Faction> dropDownMenu2 = new DropDownMenu<Faction>("Streetwarfraktion 2 (optional)", 0, 0, 0, 0).fill(Faction.values());
        dropDownMenu2.setSelected(ConfigElements.getNametagStreetwar2());
        dropDownMenu2.setEntryDrawer((object, matrixStack, x, y, string) -> LabyMod.getInstance().getDrawUtils()
                .drawString(matrixStack, Faction.valueOf(object.toString().toUpperCase()).getDisplayName(), x, y));
        DropDownElement<Faction> dropDownElement2 = new DropDownElement<>("", dropDownMenu2);
        dropDownElement2.setChangeListener(ConfigElements::setNametagStreetwar2);

        settings.add(dropDownElement0);
        settings.add(dropDownElement1);
        settings.add(dropDownElement2);
        return settings;
    }
}
