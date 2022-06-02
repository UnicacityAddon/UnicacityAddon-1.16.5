package com.rettichlp.UnicacityAddon.base.config;

import com.google.gson.JsonObject;
import com.rettichlp.UnicacityAddon.UnicacityAddon;
import com.rettichlp.UnicacityAddon.base.faction.Faction;
import com.rettichlp.UnicacityAddon.base.text.Message;
import net.labymod.gui.elements.DropDownMenu;
import net.labymod.main.LabyMod;
import net.labymod.settings.Settings;
import net.labymod.settings.elements.DropDownElement;
import net.labymod.settings.elements.HeaderElement;

public class ConfigElements {

    private static final JsonObject config = UnicacityAddon.CONFIG;

    public static boolean NAMETAG_ALLIANCE = config.has("NAMETAG_ALLIANCE") && config.get("NAMETAG_ALLIANCE").getAsBoolean(); // default = false
    public static Faction NAMETAG_ALLIANCE_1;
    public static Faction NAMETAG_ALLIANCE_2;
    public static boolean NAMETAG_FACTION = config.has("NAMETAG_FACTION") && config.get("NAMETAG_FACTION").getAsBoolean(); // default = false
    public static boolean NAMETAG_FACTIONSUFFIX = !config.has("NAMETAG_FACTIONSUFFIX") || config.get("NAMETAG_FACTIONSUFFIX").getAsBoolean(); // default = true
    public static boolean NAMETAG_HOUSEBAN = config.has("NAMETAG_HOUSEBAN") && config.get("NAMETAG_HOUSEBAN").getAsBoolean(); // default = false
    public static boolean NAMETAG_STREETWAR = config.has("NAMETAG_STREETWAR") && config.get("NAMETAG_STREETWAR").getAsBoolean(); // default = false
    public static Faction NAMETAG_STREETWAR_1;
    public static Faction NAMETAG_STREETWAR_2;

    public static Settings getNameTagForAlliance() {
        Settings settings = new Settings();

        settings.add(new HeaderElement(Message.getBuilder().of("Wenn nur eine Fraktion markiert werden soll,").advance().create()));
        settings.add(new HeaderElement(Message.getBuilder().of("müssen beide Felder auf der selben stehen.").advance().create()));

        DropDownMenu<Faction> dropDownMenu1 = new DropDownMenu<Faction>("Bündnisfraktion 1", 0, 0, 0, 0).fill(Faction.values());
        dropDownMenu1.setSelected(Faction.NULL);
        dropDownMenu1.setEntryDrawer((object, matrixStack, x, y, string) -> LabyMod.getInstance().getDrawUtils()
                .drawString(matrixStack, Faction.valueOf(object.toString().toUpperCase()).getDisplayName(), x, y));
        DropDownElement<Faction> dropDownElement1 = new DropDownElement<>("", dropDownMenu1);
        dropDownElement1.setChangeListener(faction -> NAMETAG_ALLIANCE_1 = faction);

        DropDownMenu<Faction> dropDownMenu2 = new DropDownMenu<Faction>("Bündnisfraktion 2 (optional)", 0, 0, 0, 0).fill(Faction.values());
        dropDownMenu2.setSelected(Faction.NULL);
        dropDownMenu2.setEntryDrawer((object, matrixStack, x, y, string) -> LabyMod.getInstance().getDrawUtils()
                .drawString(matrixStack, Faction.valueOf(object.toString().toUpperCase()).getDisplayName(), x, y));
        DropDownElement<Faction> dropDownElement2 = new DropDownElement<>("", dropDownMenu2);
        dropDownElement2.setChangeListener(faction -> NAMETAG_ALLIANCE_2 = faction);

        settings.add(dropDownElement1);
        settings.add(dropDownElement2);
        return settings;
    }

    public static Settings getNameTagForStreetwar() {
        Settings settings = new Settings();

        settings.add(new HeaderElement(Message.getBuilder().of("Wenn nur eine Fraktion markiert werden soll,").advance().create()));
        settings.add(new HeaderElement(Message.getBuilder().of("müssen beide Felder auf der selben stehen.").advance().create()));

        DropDownMenu<Faction> dropDownMenu1 = new DropDownMenu<Faction>("Streetwarfraktion 1", 0, 0, 0, 0).fill(Faction.values());
        dropDownMenu1.setSelected(Faction.NULL);
        dropDownMenu1.setEntryDrawer((object, matrixStack, x, y, string) -> LabyMod.getInstance().getDrawUtils()
                .drawString(matrixStack, Faction.valueOf(object.toString().toUpperCase()).getDisplayName(), x, y));
        DropDownElement<Faction> dropDownElement1 = new DropDownElement<>("", dropDownMenu1);
        dropDownElement1.setChangeListener(faction -> NAMETAG_STREETWAR_1 = faction);

        DropDownMenu<Faction> dropDownMenu2 = new DropDownMenu<Faction>("Streetwarfraktion 2 (optional)", 0, 0, 0, 0).fill(Faction.values());
        dropDownMenu2.setSelected(Faction.NULL);
        dropDownMenu2.setEntryDrawer((object, matrixStack, x, y, string) -> LabyMod.getInstance().getDrawUtils()
                .drawString(matrixStack, Faction.valueOf(object.toString().toUpperCase()).getDisplayName(), x, y));
        DropDownElement<Faction> dropDownElement2 = new DropDownElement<>("", dropDownMenu2);
        dropDownElement2.setChangeListener(faction -> NAMETAG_STREETWAR_2 = faction);

        settings.add(dropDownElement1);
        settings.add(dropDownElement2);
        return settings;
    }
}
