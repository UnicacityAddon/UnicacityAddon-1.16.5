package com.rettichlp.UnicacityAddon.base.command;

import com.rettichlp.UnicacityAddon.base.abstraction.UPlayer;

/**
 * @author RettichLP
 */
public interface UnicacityCommand {

    boolean onCommand(UPlayer p, String[] args);
}