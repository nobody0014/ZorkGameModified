package io.muic.ooc.Command.ActualCommand;

import io.muic.ooc.Command.Command;
import io.muic.ooc.MainLoop.ZorkView;

/**
 * Created by wit on 2/1/2017 AD.
 */
public class Help extends Command {
    @Override
    public boolean execute() {
        ZorkView.printHelp();
        return true;
    }
}
