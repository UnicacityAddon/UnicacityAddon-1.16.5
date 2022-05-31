package com.rettichlp.UnicacityAddon.base.abstraction;

import com.google.gson.JsonObject;
import com.rettichlp.UnicacityAddon.UnicacityAddon;

/**
 * @author RettichLP
 * @see <a href="https://github.com/paulzhng/UCUtils/blob/master/src/main/java/de/fuzzlemann/ucutils/base/abstraction/UPlayerImpl.java">UCUtils by paulzhng</a>
 */
public class ConfigImpl implements Config {

    // this.numberExample = getConfig().has( "number" ) ? getConfig().get( "number" ).getAsInt() : 5; // <- default value '5'

    @Override
    public JsonObject getConfig() {
        return UnicacityAddon.CONFIG;
    }

    @Override // default = true
    public boolean getEventCarTankWarning() {
        return !getConfig().has("event.car.tankWarning") || getConfig().get("event.car.tankWarning").getAsBoolean();
    }

    @Override // default = true
    public boolean getCommandJobsDropammo() {
        return !getConfig().has("command.jobs.dropammo") || getConfig().get("command.jobs.dropammo").getAsBoolean();
    }

    @Override // default = true
    public boolean getCommandJobsDroptransport() {
        return !getConfig().has("command.jobs.droptransport") || getConfig().get("command.jobs.droptransport").getAsBoolean();
    }

    @Override // default = true
    public boolean getCommandJobsDropwaste() {
        return !getConfig().has("command.jobs.dropwaste") || getConfig().get("command.jobs.dropwaste").getAsBoolean();
    }
}
