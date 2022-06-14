package com.rettichlp.UnicacityAddon.base.abstraction;

import com.google.gson.JsonObject;
import com.rettichlp.UnicacityAddon.UnicacityAddon;
import net.labymod.api.LabyModAPI;
import net.labymod.api.event.EventService;
import net.labymod.main.LabyMod;

/**
 * @author RettichLP
 * @see <a href="https://github.com/paulzhng/UCUtils/blob/master/src/main/java/de/fuzzlemann/ucutils/base/abstraction/UPlayer.java">UCUtils by paulzhng</a>
 */
public interface Labymod {

    UnicacityAddon getAddon();

    LabyMod getLabymod();

    EventService getEventService();

    LabyModAPI getApi();

    JsonObject getConfig();
}
