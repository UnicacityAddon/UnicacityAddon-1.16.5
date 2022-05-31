package com.rettichlp.UnicacityAddon.base.abstraction;

import com.google.gson.JsonObject;

/**
 * @author RettichLP
 * @see <a href="https://github.com/paulzhng/UCUtils/blob/master/src/main/java/de/fuzzlemann/ucutils/base/abstraction/UPlayer.java">UCUtils by paulzhng</a>
 */
public interface Config {

    JsonObject getConfig();

    boolean getEventCarTankWarning();

    boolean getCommandJobsDropammo();

    boolean getCommandJobsDroptransport();

    boolean getCommandJobsDropwaste();
}
