package com.rettichlp.UnicacityAddon.events;

import com.rettichlp.UnicacityAddon.base.abstraction.AbstractionLayer;
import com.rettichlp.UnicacityAddon.base.config.ConfigElements;
import com.rettichlp.UnicacityAddon.base.text.PatternHandler;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.events.client.chat.MessageReceiveEvent;

import java.util.regex.Matcher;

public class ATMInfoEventHandler {

    @Subscribe
    public void onMessage(MessageReceiveEvent e) {
        if (!ConfigElements.getEventATMInfo()) return;

        Matcher kontoauszugMatcher = PatternHandler.KONTOAUSZUG_PATTERN.matcher(e.getComponent().getString());
        if (kontoauszugMatcher.find()) AbstractionLayer.getPlayer().sendChatMessage("/atminfo");
    }
}