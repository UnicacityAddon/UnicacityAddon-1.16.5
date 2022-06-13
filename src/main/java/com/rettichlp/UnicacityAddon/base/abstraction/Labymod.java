package com.rettichlp.UnicacityAddon.base.abstraction;

import net.labymod.api.event.EventService;
import net.labymod.main.LabyMod;

/**
 * @author RettichLP
 * @see <a href="https://github.com/paulzhng/UCUtils/blob/master/src/main/java/de/fuzzlemann/ucutils/base/abstraction/UPlayer.java">UCUtils by paulzhng</a>
 */
public interface Labymod {

    LabyMod getLabymod();

    EventService getEventService();
}
