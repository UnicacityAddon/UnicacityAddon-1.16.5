package com.rettichlp.UnicacityAddon.events;

import com.rettichlp.UnicacityAddon.base.event.UCEvent;
import com.rettichlp.UnicacityAddon.base.text.ColorCode;
import com.rettichlp.UnicacityAddon.base.text.PatternHandler;
import com.rettichlp.UnicacityAddon.modules.BombTimerModule;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.events.client.TickEvent;
import net.labymod.api.event.events.client.chat.MessageReceiveEvent;
import net.labymod.utils.ModUtils;

@UCEvent
public class BombTimerEventHandler {

    @Subscribe
    public void onTick(TickEvent event) {
        if (event.getPhase() != TickEvent.Phase.POST) return;

        if (!BombTimerModule.isBomb || ++BombTimerModule.currentTick != 20) return;
        BombTimerModule.currentTick = 0;

        if (BombTimerModule.currentCount++ >= 780) BombTimerModule.timer = ColorCode.RED.getCode() + ModUtils.parseTimer(BombTimerModule.currentCount);
        else BombTimerModule.timer = ModUtils.parseTimer(BombTimerModule.currentCount);

        if (BombTimerModule.currentCount > 1200) stopBombTimer();
    }

    @Subscribe
    public void onMesageReceive(MessageReceiveEvent e) {
        String msg = e.getComponent().getString();

        if (PatternHandler.BOMB_PLACED_PATTERN.matcher(msg).find()) {
            BombTimerModule.isBomb = true;
            BombTimerModule.timer = "00:00";
            return;
        }

        if (PatternHandler.BOMB_REMOVED_PATTERN.matcher(msg).find()) stopBombTimer();
    }

    private void stopBombTimer() {
        BombTimerModule.isBomb = false;
        BombTimerModule.currentCount = 0;
        BombTimerModule.timer = "";
    }
}