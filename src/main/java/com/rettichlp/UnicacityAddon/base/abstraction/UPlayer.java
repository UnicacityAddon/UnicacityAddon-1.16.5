package com.rettichlp.UnicacityAddon.base.abstraction;

import com.rettichlp.UnicacityAddon.base.faction.Faction;
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
 * @see <a href="https://github.com/paulzhng/UCUtils/blob/master/src/main/java/de/fuzzlemann/ucutils/base/abstraction/UPlayer.java">UCUtils by paulzhng</a>
 */
public interface UPlayer {

    ClientPlayerEntity getPlayer();

    String getName();

    UUID getUUID();

    String getStringUUID();

    MinecraftServer getMinecraftServer();

    Scoreboard getScoreboard();

    World getWorld();

    BlockPos getPosition();

    void sendMessage(ITextComponent message);

    void sendMessageAsString(String message);

    void playSound(SoundEvent soundEvent, Float volume, Float pitch);

    PlayerInventory getInventory();

    PlayerContainer getContainer();

    ClientPlayNetHandler getConnection();

    Faction getFaction();
}
