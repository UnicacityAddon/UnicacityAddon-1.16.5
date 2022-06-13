package com.rettichlp.UnicacityAddon.base.abstraction;

import com.google.gson.JsonObject;
import com.rettichlp.UnicacityAddon.UnicacityAddon;
import net.labymod.api.LabyModAPI;
import net.labymod.api.event.EventService;
import net.labymod.main.LabyMod;

/**
 * @author RettichLP
 * @see <a href="https://github.com/paulzhng/UCUtils/blob/master/src/main/java/de/fuzzlemann/ucutils/base/abstraction/UPlayerImpl.java">UCUtils by paulzhng</a>
 */
public class LabymodImpl implements Labymod {

    @Override public UnicacityAddon getAddon() {
        return UnicacityAddon.ADDON;
    }

    @Override public LabyMod getLabymod() {
        return LabyMod.getInstance();
    }

    @Override public EventService getEventService() {
        return getLabymod().getEventService();
    }

    @Override public LabyModAPI getApi() {
        return getAddon().getApi();
    }

    @Override public JsonObject getConfig() {
        return getAddon().getConfig();
    }
}
