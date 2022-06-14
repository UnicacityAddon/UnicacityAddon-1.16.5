package com.rettichlp.UnicacityAddon.base.config;

import com.rettichlp.UnicacityAddon.base.abstraction.AbstractionLayer;
import com.rettichlp.UnicacityAddon.base.faction.Faction;
import com.rettichlp.UnicacityAddon.base.text.ColorCode;
import org.jetbrains.annotations.NotNull;

public class ConfigElements {

    // FACTION
    public static boolean getNameTagFaction() {
        return AbstractionLayer.getLabymod().getConfig().has("NAMETAG_FACTION") && AbstractionLayer.getLabymod().getConfig().get("NAMETAG_FACTION")
                .getAsBoolean(); // default = false
    }

    public static ColorCode getNameTagFactionColor() {
        return AbstractionLayer.getLabymod().getConfig().has("NAMETAG_FACTION_COLOR") ?
                ColorCode.valueOf(AbstractionLayer.getLabymod().getConfig().get("NAMETAG_FACTION_COLOR").getAsString()) :
                ColorCode.BLUE; // default = BLUE
    }

    public static void setNameTagFactionColor(@NotNull ColorCode factionColor) {
        AbstractionLayer.getLabymod().getConfig().addProperty("NAMETAG_FACTION_COLOR", factionColor.toString());
    }

    // FACTIONSUFFIX
    public static boolean getNameTagFactionSuffix() {
        return !AbstractionLayer.getLabymod().getConfig().has("NAMETAG_FACTIONSUFFIX") || AbstractionLayer.getLabymod().getConfig().get("NAMETAG_FACTIONSUFFIX")
                .getAsBoolean(); // default = true
    }

    // HOUSEBAN
    public static boolean getNameTagHouseban() {
        return AbstractionLayer.getLabymod().getConfig().has("NAMETAG_HOUSEBAN") && AbstractionLayer.getLabymod().getConfig().get("NAMETAG_HOUSEBAN")
                .getAsBoolean(); // default = false
    }

    // ALLIANCE
    public static boolean getNameTagAlliance() {
        return AbstractionLayer.getLabymod().getConfig().has("NAMETAG_ALLIANCE") && AbstractionLayer.getLabymod().getConfig().get("NAMETAG_ALLIANCE")
                .getAsBoolean(); // default = false
    }

    public static ColorCode getNameTagAllianceColor() {
        return AbstractionLayer.getLabymod().getConfig().has("NAMETAG_ALLIANCE_COLOR") ?
                ColorCode.valueOf(AbstractionLayer.getLabymod().getConfig().get("NAMETAG_ALLIANCE_COLOR").getAsString()) :
                ColorCode.DARK_PURPLE; // default = DARK_PURPLE
    }

    public static Faction getNameTagAlliance1() {
        return AbstractionLayer.getLabymod().getConfig().has("NAMETAG_ALLIANCE1") ?
                Faction.valueOf(AbstractionLayer.getLabymod().getConfig().get("NAMETAG_ALLIANCE1").getAsString()) :
                Faction.NULL; // default = NULL
    }

    public static Faction getNameTagAlliance2() {
        return AbstractionLayer.getLabymod().getConfig().has("NAMETAG_ALLIANCE2") ?
                Faction.valueOf(AbstractionLayer.getLabymod().getConfig().get("NAMETAG_ALLIANCE2").getAsString()) :
                Faction.NULL; // default = NULL
    }

    public static void setNameTagAllianceColor(@NotNull ColorCode allianceColor) {
        AbstractionLayer.getLabymod().getConfig().addProperty("NAMETAG_ALLIANCE_COLOR", allianceColor.toString());
    }

    public static void setNameTagAlliance1(@NotNull Faction allianceFaction1) {
        AbstractionLayer.getLabymod().getConfig().addProperty("NAMETAG_ALLIANCE1", allianceFaction1.toString());
    }

    public static void setNameTagAlliance2(@NotNull Faction allianceFaction2) {
        AbstractionLayer.getLabymod().getConfig().addProperty("NAMETAG_ALLIANCE2", allianceFaction2.toString());
    }

    // STREETWAR
    public static boolean getNameTagStreetwar() {
        return AbstractionLayer.getLabymod().getConfig().has("NAMETAG_STREETWAR") && AbstractionLayer.getLabymod().getConfig().get("NAMETAG_STREETWAR")
                .getAsBoolean(); // default = false
    }

    public static ColorCode getNameTagStreetwarColor() {
        return AbstractionLayer.getLabymod().getConfig().has("NAMETAG_STREETWAR_COLOR") ?
                ColorCode.valueOf(AbstractionLayer.getLabymod().getConfig().get("NAMETAG_STREETWAR_COLOR").getAsString()) :
                ColorCode.DARK_RED; // default = DARK_RED
    }

    public static Faction getNameTagStreetwar1() {
        return AbstractionLayer.getLabymod().getConfig().has("NAMETAG_STREETWAR1") ?
                Faction.valueOf(AbstractionLayer.getLabymod().getConfig().get("NAMETAG_STREETWAR1").getAsString()) :
                Faction.NULL; // default = NULL
    }

    public static Faction getNameTagStreetwar2() {
        return AbstractionLayer.getLabymod().getConfig().has("NAMETAG_STREETWAR2") ?
                Faction.valueOf(AbstractionLayer.getLabymod().getConfig().get("NAMETAG_STREETWAR2").getAsString()) :
                Faction.NULL; // default = NULL
    }

    public static void setNameTagStreetwarColor(@NotNull ColorCode streetwarColor) {
        AbstractionLayer.getLabymod().getConfig().addProperty("NAMETAG_STREETWAR_COLOR", streetwarColor.toString());
    }

    public static void setNameTagStreetwar1(@NotNull Faction streetwarFaction1) {
        AbstractionLayer.getLabymod().getConfig().addProperty("NAMETAG_STREETWAR1", streetwarFaction1.toString());
    }

    public static void setNameTagStreetwar2(@NotNull Faction streetwarFaction2) {
        AbstractionLayer.getLabymod().getConfig().addProperty("NAMETAG_STREETWAR2", streetwarFaction2.toString());
    }

    // ATMINFO
    public static boolean getEventATMInfo() {
        return !AbstractionLayer.getLabymod().getConfig().has("EVENT_ATMINFO") || AbstractionLayer.getLabymod().getConfig().get("EVENT_ATMINFO")
                .getAsBoolean(); // default = true
    }
}