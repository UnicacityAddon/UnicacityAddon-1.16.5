package com.rettichlp.UnicacityAddon.events;

import com.rettichlp.UnicacityAddon.base.abstraction.AbstractionLayer;
import com.rettichlp.UnicacityAddon.base.config.ConfigElements;
import com.rettichlp.UnicacityAddon.base.faction.Faction;
import com.rettichlp.UnicacityAddon.base.faction.FactionHandler;
import com.rettichlp.UnicacityAddon.base.text.ColorCode;
import com.rettichlp.UnicacityAddon.base.text.FormattingCode;
import com.rettichlp.UnicacityAddon.base.text.Message;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.events.client.renderer.RenderNameTagEvent;
import net.minecraft.util.text.ITextComponent;

public class NameTagEventHandler {

    private static String playerName;

    @Subscribe
    public void onRenderNameTag(RenderNameTagEvent e) {
        playerName = e.getDisplayName().getString();

        StringBuilder nameTag = new StringBuilder();
        String nameTagSuffix = "";

        if (ConfigElements.NAMETAG_HOUSEBAN) nameTag.append(getHouseBan());

        if (FactionHandler.getPlayerFactionMap().containsKey(playerName)) {
            Faction targetPlayerFaction = FactionHandler.getPlayerFactionMap().get(playerName);

            if (ConfigElements.NAMETAG_FACTION) {
                if (targetPlayerFaction.equals(AbstractionLayer.getPlayer().getFaction()))
                    nameTag.append(ColorCode.BLUE.getCode());
            }

            if (ConfigElements.NAMETAG_ALLIANCE) {
                if (targetPlayerFaction.equals(ConfigElements.NAMETAG_ALLIANCE_1) || targetPlayerFaction.equals(ConfigElements.NAMETAG_ALLIANCE_2))
                    nameTag.append(ColorCode.LIGHT_PURPLE.getCode());
            }

            if (ConfigElements.NAMETAG_STREETWAR) {
                if (targetPlayerFaction.equals(ConfigElements.NAMETAG_STREETWAR_1) || targetPlayerFaction.equals(ConfigElements.NAMETAG_STREETWAR_2))
                    nameTag.append(ColorCode.DARK_RED.getCode());
            }

            if (ConfigElements.NAMETAG_FACTIONSUFFIX) nameTagSuffix = " " + targetPlayerFaction.getNameTagSuffix();
        }

        nameTag.append(playerName);
        nameTag.append(nameTagSuffix);

        e.setDisplayName(ITextComponent.getTextComponentOrEmpty(nameTag.toString()));
    }

    private String getHouseBan() {
        if (!FactionHandler.checkPlayerHouseBan(playerName)) return "";
        return Message.getBuilder()
                .of("[").color(ColorCode.DARK_GRAY).advance()
                .of("HV").color(ColorCode.RED).advance()
                .of("]").color(ColorCode.DARK_GRAY).advance()
                .add(FormattingCode.RESET.getCode())
                .create();
    }
}