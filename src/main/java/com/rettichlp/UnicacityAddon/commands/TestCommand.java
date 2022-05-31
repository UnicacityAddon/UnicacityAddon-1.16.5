package com.rettichlp.UnicacityAddon.commands;

import com.rettichlp.UnicacityAddon.base.abstraction.UPlayer;
import com.rettichlp.UnicacityAddon.base.command.Command;
import com.rettichlp.UnicacityAddon.base.command.UnicacityCommand;

/**
 * @author RettichLP
 */
public class TestCommand implements UnicacityCommand {

    @Override
    @Command(value = {"test1", "test2"}, usage = "/%label% [test] [test]")
    public boolean onCommand(UPlayer p, String[] args) {
        System.out.println("test1");
        return false;
    }
}
