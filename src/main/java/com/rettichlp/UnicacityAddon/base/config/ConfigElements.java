package com.rettichlp.UnicacityAddon.base.config;

import com.rettichlp.UnicacityAddon.UnicacityAddon;
import com.rettichlp.UnicacityAddon.base.faction.Faction;
import com.rettichlp.UnicacityAddon.base.text.ColorCode;
import org.jetbrains.annotations.NotNull;

public class ConfigElements {

    // FACTION
    public static boolean getNameTagFaction() {
        return UnicacityAddon.CONFIG.has("NAMETAG_FACTION") && UnicacityAddon.CONFIG.get("NAMETAG_FACTION").getAsBoolean(); // default = false
    }

    public static ColorCode getNameTagFactionColor() {
        return UnicacityAddon.CONFIG.has("NAMETAG_FACTION_COLOR") ? ColorCode.valueOf(UnicacityAddon.CONFIG.get("NAMETAG_FACTION_COLOR").getAsString()) : ColorCode.BLUE; // default = BLUE
    }

    public static void setNameTagFactionColor(ColorCode factionColor) {
        UnicacityAddon.CONFIG.addProperty("NAMETAG_FACTION_COLOR", factionColor.toString());
    }

    // FACTIONSUFFIX
    public static boolean getNameTagFactionSuffix() {
        return !UnicacityAddon.CONFIG.has("NAMETAG_FACTIONSUFFIX") || UnicacityAddon.CONFIG.get("NAMETAG_FACTIONSUFFIX").getAsBoolean(); // default = true
    }

    // HOUSEBAN
    public static boolean getNameTagHouseban() {
        return UnicacityAddon.CONFIG.has("NAMETAG_HOUSEBAN") && UnicacityAddon.CONFIG.get("NAMETAG_HOUSEBAN").getAsBoolean(); // default = false
    }

    // ALLIANCE
    public static boolean getNameTagAlliance() {
        return UnicacityAddon.CONFIG.has("NAMETAG_ALLIANCE") && UnicacityAddon.CONFIG.get("NAMETAG_ALLIANCE").getAsBoolean(); // default = false
    }

    public static ColorCode getNameTagAllianceColor() {
        return UnicacityAddon.CONFIG.has("NAMETAG_ALLIANCE_COLOR") ? ColorCode.valueOf(UnicacityAddon.CONFIG.get("NAMETAG_ALLIANCE_COLOR").getAsString()) : ColorCode.DARK_PURPLE; // default = DARK_PURPLE
    }

    public static Faction getNameTagAlliance1() {
        return UnicacityAddon.CONFIG.has("NAMETAG_ALLIANCE1") ? Faction.valueOf(UnicacityAddon.CONFIG.get("NAMETAG_ALLIANCE1").getAsString()) : Faction.NULL; // default = NULL
    }

    public static Faction getNameTagAlliance2() {
        return UnicacityAddon.CONFIG.has("NAMETAG_ALLIANCE2") ? Faction.valueOf(UnicacityAddon.CONFIG.get("NAMETAG_ALLIANCE2").getAsString()) : Faction.NULL; // default = NULL
    }

    public static void setNameTagAllianceColor(ColorCode allianceColor) {
        UnicacityAddon.CONFIG.addProperty("NAMETAG_ALLIANCE_COLOR", allianceColor.toString());
    }

    public static void setNameTagAlliance1(Faction allianceFaction1) {
        UnicacityAddon.CONFIG.addProperty("NAMETAG_ALLIANCE1", allianceFaction1.toString());
    }

    public static void setNameTagAlliance2(Faction allianceFaction2) {
        UnicacityAddon.CONFIG.addProperty("NAMETAG_ALLIANCE2", allianceFaction2.toString());
    }

    // STREETWAR
    public static boolean getNameTagStreetwar() {
        return UnicacityAddon.CONFIG.has("NAMETAG_STREETWAR") && UnicacityAddon.CONFIG.get("NAMETAG_STREETWAR").getAsBoolean(); // default = false
    }

    public static ColorCode getNameTagStreetwarColor() {
        return UnicacityAddon.CONFIG.has("NAMETAG_STREETWAR_COLOR") ? ColorCode.valueOf(UnicacityAddon.CONFIG.get("NAMETAG_STREETWAR_COLOR").getAsString()) : ColorCode.DARK_RED; // default = DARK_RED
    }

    public static Faction getNameTagStreetwar1() {
        return UnicacityAddon.CONFIG.has("NAMETAG_STREETWAR1") ? Faction.valueOf(UnicacityAddon.CONFIG.get("NAMETAG_STREETWAR1").getAsString()) : Faction.NULL; // default = NULL
    }

    public static Faction getNameTagStreetwar2() {
        return UnicacityAddon.CONFIG.has("NAMETAG_STREETWAR2") ? Faction.valueOf(UnicacityAddon.CONFIG.get("NAMETAG_STREETWAR2").getAsString()) : Faction.NULL; // default = NULL
    }

    public static void setNameTagStreetwarColor(@NotNull ColorCode streetwarColor) {
        UnicacityAddon.CONFIG.addProperty("NAMETAG_STREETWAR_COLOR", streetwarColor.toString());
    }

    public static void setNameTagStreetwar1(@NotNull Faction streetwarFaction1) {
        UnicacityAddon.CONFIG.addProperty("NAMETAG_STREETWAR1", streetwarFaction1.toString());
    }

    public static void setNameTagStreetwar2(@NotNull Faction streetwarFaction2) {
        UnicacityAddon.CONFIG.addProperty("NAMETAG_STREETWAR2", streetwarFaction2.toString());
    }
}