package com.rettichlp.UnicacityAddon.base.config;

import com.rettichlp.UnicacityAddon.UnicacityAddon;
import com.rettichlp.UnicacityAddon.base.faction.Faction;

public class ConfigElements {

    public static boolean getNametagFaction() {
        return UnicacityAddon.CONFIG.has("NAMETAG_FACTION") && UnicacityAddon.CONFIG.get("NAMETAG_FACTION").getAsBoolean(); // default = false
    }

    public static boolean getNametagFactionSuffix() {
        return !UnicacityAddon.CONFIG.has("NAMETAG_FACTIONSUFFIX") || UnicacityAddon.CONFIG.get("NAMETAG_FACTIONSUFFIX").getAsBoolean(); // default = true
    }

    public static boolean getNametagHouseban() {
        return UnicacityAddon.CONFIG.has("NAMETAG_HOUSEBAN") && UnicacityAddon.CONFIG.get("NAMETAG_HOUSEBAN").getAsBoolean(); // default = false
    }

    // ALLIANCE
    public static boolean getNametagAlliance() {
        return UnicacityAddon.CONFIG.has("NAMETAG_ALLIANCE") && UnicacityAddon.CONFIG.get("NAMETAG_ALLIANCE").getAsBoolean(); // default = false
    }

    public static Faction getNametagAlliance1() {
        return UnicacityAddon.CONFIG.has("NAMETAG_ALLIANCE1") ? Faction.valueOf(UnicacityAddon.CONFIG.get("NAMETAG_ALLIANCE1").getAsString()) : Faction.NULL; // default = NULL
    }

    public static Faction getNametagAlliance2() {
        return UnicacityAddon.CONFIG.has("NAMETAG_ALLIANCE2") ? Faction.valueOf(UnicacityAddon.CONFIG.get("NAMETAG_ALLIANCE2").getAsString()) : Faction.NULL; // default = NULL
    }

    public static void setNametagAlliance1(Faction allianceFaction1) {
        UnicacityAddon.CONFIG.addProperty("NAMETAG_ALLIANCE1", allianceFaction1.toString());
    }

    public static void setNametagAlliance2(Faction allianceFaction2) {
        UnicacityAddon.CONFIG.addProperty("NAMETAG_ALLIANCE2", allianceFaction2.toString());
    }

    // STREETWAR
    public static boolean getNametagStreetwar() {
        return UnicacityAddon.CONFIG.has("NAMETAG_STREETWAR") && UnicacityAddon.CONFIG.get("NAMETAG_STREETWAR").getAsBoolean(); // default = false
    }

    public static Faction getNametagStreetwar1() {
        return UnicacityAddon.CONFIG.has("NAMETAG_STREETWAR1") ? Faction.valueOf(UnicacityAddon.CONFIG.get("NAMETAG_STREETWAR1").getAsString()) : Faction.NULL; // default = NULL
    }

    public static Faction getNametagStreetwar2() {
        return UnicacityAddon.CONFIG.has("NAMETAG_STREETWAR2") ? Faction.valueOf(UnicacityAddon.CONFIG.get("NAMETAG_STREETWAR2").getAsString()) : Faction.NULL; // default = NULL
    }

    public static void setNametagStreetwar1(Faction streetwarFaction1) {
        UnicacityAddon.CONFIG.addProperty("NAMETAG_STREETWAR1", streetwarFaction1.toString());
    }

    public static void setNametagStreetwar2(Faction streetwarFaction2) {
        UnicacityAddon.CONFIG.addProperty("NAMETAG_STREETWAR2", streetwarFaction2.toString());
    }
}