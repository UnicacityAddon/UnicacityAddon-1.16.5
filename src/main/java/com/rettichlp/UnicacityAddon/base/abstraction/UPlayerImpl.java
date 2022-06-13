package com.rettichlp.UnicacityAddon.base.abstraction;

import com.rettichlp.UnicacityAddon.UnicacityAddon;
import com.rettichlp.UnicacityAddon.base.faction.Faction;
import com.rettichlp.UnicacityAddon.base.faction.FactionHandler;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.network.play.ClientPlayNetHandler;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.PlayerContainer;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import java.util.UUID;

/**
 * @author RettichLP
 * @see <a href="https://github.com/paulzhng/UCUtils/blob/master/src/main/java/de/fuzzlemann/ucutils/base/abstraction/UPlayerImpl.java">UCUtils by paulzhng</a>
 */
public class UPlayerImpl implements UPlayer {

    @Override
    public ClientPlayerEntity getPlayer() {
        return UnicacityAddon.MINECRAFT.player;
    }

    @Override
    public String getName() {
        return getPlayer().getDisplayName().getString();
    }

    @Override
    public UUID getUUID() {
        return getPlayer().getUniqueID();
    }

    @Override
    public String getStringUUID() {
        return getUUID().toString();
    }

    @Override
    public MinecraftServer getMinecraftServer() {
        return getPlayer().getServer();
    }

    @Override
    public Scoreboard getScoreboard() {
        return getPlayer().getWorldScoreboard();
    }

    @Override
    public World getWorld() {
        return getPlayer().getEntityWorld();
    }

    @Override
    public BlockPos getPosition() {
        return getPlayer().getPosition();
    }

    @Override
    public void sendMessage(ITextComponent message) {
        getPlayer().sendMessage(message, getUUID());
    }

    @Override
    public void sendMessageAsString(String message) {
        sendMessage(ITextComponent.getTextComponentOrEmpty(message));
    }

    @Override
    public void sendChatMessage(String message) {
        getPlayer().sendChatMessage(message);
    }

    @Override
    public void playSound(SoundEvent soundEvent, Float volume, Float pitch) {
        getPlayer().playSound(soundEvent, volume, pitch);
    }

    @Override
    public PlayerInventory getInventory() {
        return getPlayer().inventory;
    }

    @Override
    public PlayerContainer getContainer() {
        return getPlayer().container;
    }

    @Override
    public ClientPlayNetHandler getConnection() {
        return getPlayer().connection;
    }

    @Override
    public Faction getFaction() {
        if (FactionHandler.getPlayerFactionMap().containsKey(getName())) return FactionHandler.getPlayerFactionMap().get(getName());
        return Faction.NULL;
    }
}
