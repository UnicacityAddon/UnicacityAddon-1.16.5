package com.rettichlp.UnicacityAddon.base.config;

import com.rettichlp.UnicacityAddon.UnicacityAddon;
import com.rettichlp.UnicacityAddon.base.faction.Faction;

public class ConfigElements {
    private static Faction nametagAlliance1;
    private static Faction nametagAlliance2;
    private static Faction nametagStreetwar1;
    private static Faction nametagStreetwar2;

    public static boolean getNametagFaction() {
        return UnicacityAddon.CONFIG.has("NAMETAG_FACTION") && UnicacityAddon.CONFIG.get("NAMETAG_FACTION").getAsBoolean(); // default = false
    }

    public static boolean getNametagFactionSuffix() {
        return !UnicacityAddon.CONFIG.has("NAMETAG_FACTIONSUFFIX") || UnicacityAddon.CONFIG.get("NAMETAG_FACTIONSUFFIX").getAsBoolean(); // default = true
    }

    public static boolean getNametagHouseban() {
        return UnicacityAddon.CONFIG.has("NAMETAG_HOUSEBAN") && UnicacityAddon.CONFIG.get("NAMETAG_HOUSEBAN").getAsBoolean(); // default = false
    }

    public static boolean getNametagAlliance() {
        return UnicacityAddon.CONFIG.has("NAMETAG_ALLIANCE") && UnicacityAddon.CONFIG.get("NAMETAG_ALLIANCE").getAsBoolean(); // default = false
    }

    public static Faction getNametagAlliance1() {
        return nametagAlliance1;
    }

    public static Faction getNametagAlliance2() {
        return nametagAlliance2;
    }

    public static void setNametagAlliance1(Faction allianceFaction1) {
        nametagAlliance1 = allianceFaction1;
    }

    public static void setNametagAlliance2(Faction allianceFaction2) {
        nametagAlliance2 = allianceFaction2;
    }

    public static boolean getNametagStreetwar() {
        return UnicacityAddon.CONFIG.has("NAMETAG_STREETWAR") && UnicacityAddon.CONFIG.get("NAMETAG_STREETWAR").getAsBoolean(); // default = false
    }

    public static Faction getNametagStreetwar1() {
        return nametagStreetwar1;
    }

    public static Faction getNametagStreetwar2() {
        return nametagStreetwar2;
    }

    public static void setNametagStreetwar1(Faction streetwarFaction1) {
        nametagStreetwar1 = streetwarFaction1;
    }

    public static void setNametagStreetwar2(Faction streetwarFaction2) {
        nametagStreetwar2 = streetwarFaction2;
    }
}
