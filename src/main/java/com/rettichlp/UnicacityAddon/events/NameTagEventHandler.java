package com.rettichlp.UnicacityAddon.events;

import com.rettichlp.UnicacityAddon.UnicacityAddon;
import com.rettichlp.UnicacityAddon.base.abstraction.AbstractionLayer;
import com.rettichlp.UnicacityAddon.base.config.ConfigElements;
import com.rettichlp.UnicacityAddon.base.faction.Faction;
import com.rettichlp.UnicacityAddon.base.faction.FactionHandler;
import com.rettichlp.UnicacityAddon.base.text.ColorCode;
import com.rettichlp.UnicacityAddon.base.text.FormattingCode;
import com.rettichlp.UnicacityAddon.base.text.Message;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.events.client.TickEvent;
import net.labymod.api.event.events.client.renderer.RenderNameTagEvent;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.Items;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class NameTagEventHandler {

    private static int tick;

    @Subscribe
    public void onRenderNameTag(RenderNameTagEvent e) {
        String playerName = e.getDisplayName().getString();
        String prefix = getPrefix(playerName);
        String suffix = getSuffix(playerName);
        e.setDisplayName(ITextComponent.getTextComponentOrEmpty(prefix + playerName + suffix));
    }

    @Subscribe
    public void onTick(TickEvent e) {
        if (e.getPhase() != TickEvent.Phase.PRE) return;
        if (UnicacityAddon.MINECRAFT.world == null) return;
        if (tick++ != 20) return;

        BlockPos pos = AbstractionLayer.getPlayer().getPosition();
        List<ItemEntity> itemEntities = UnicacityAddon.MINECRAFT.world.getEntitiesWithinAABB(ItemEntity.class,
                new AxisAlignedBB(pos.getX() - 30, pos.getY() - 30, pos.getZ() - 30, pos.getX() + 30, pos.getY() + 30, pos.getZ() + 30),
                itemEntity -> itemEntity != null && itemEntity.hasCustomName() && itemEntity.getItem().getItem().equals(Items.SKELETON_SKULL));

        for (ItemEntity itemEntity : itemEntities) {
            String name = itemEntity.getCustomName().getString();
            String playerName = name.substring(3);

            String prefix = getPrefix(playerName);
            String suffix = getSuffix(playerName);

            if (name.startsWith(ColorCode.DARK_GRAY.getCode())) { // non-revivable
                itemEntity.setCustomName(ITextComponent.getTextComponentOrEmpty(ColorCode.DARK_GRAY.getCode() + "✟" + playerName + suffix));
                continue;
            }

            itemEntity.setCustomName(ITextComponent.getTextComponentOrEmpty(prefix + "✟" + playerName + suffix));
        }

        tick = 0;
    }

    private @NotNull String getPrefix(String playerName) {
        StringBuilder prefix = new StringBuilder();

        if (ConfigElements.getNametagHouseban()) {
            if (FactionHandler.checkPlayerHouseBan(playerName)) prefix.append(Message.getBuilder()
                    .of("[").color(ColorCode.DARK_GRAY).advance()
                    .of("HV").color(ColorCode.RED).advance()
                    .of("]").color(ColorCode.DARK_GRAY).advance()
                    .add(FormattingCode.RESET.getCode())
                    .create());
        }

        if (FactionHandler.getPlayerFactionMap().containsKey(playerName)) {
            Faction targetPlayerFaction = FactionHandler.getPlayerFactionMap().get(playerName);

            if (ConfigElements.getNametagFaction()) {
                if (targetPlayerFaction.equals(AbstractionLayer.getPlayer().getFaction()))
                    prefix.append(ConfigElements.getNametagFactionColor().getCode());
            }

            if (ConfigElements.getNametagAlliance()) {
                if (targetPlayerFaction.equals(ConfigElements.getNametagAlliance1()) || targetPlayerFaction.equals(ConfigElements.getNametagAlliance2()))
                    prefix.append(ConfigElements.getNametagAllianceColor().getCode());
            }

            if (ConfigElements.getNametagStreetwar()) {
                if (targetPlayerFaction.equals(ConfigElements.getNametagStreetwar1()) || targetPlayerFaction.equals(ConfigElements.getNametagStreetwar2()))
                    prefix.append(ConfigElements.getNametagStreetwarColor().getCode());
            }
        }

        return prefix.toString();
    }

    private @NotNull String getSuffix(String playerName) {
        StringBuilder suffix = new StringBuilder();

        if (FactionHandler.getPlayerFactionMap().containsKey(playerName)) {
            Faction targetPlayerFaction = FactionHandler.getPlayerFactionMap().get(playerName);
            if (ConfigElements.getNametagFactionSuffix()) suffix.append(" ").append(targetPlayerFaction.getNameTagSuffix());
        }

        return suffix.append(FormattingCode.RESET.getCode()).toString();
    }
}