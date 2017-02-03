package io.muic.ooc.Command.ActualCommand;

import io.muic.ooc.Command.Command;

/**
 * Created by wit on 2/1/2017 AD.
 */
public class Look extends Command {

    /**
     * Look at a chance item?
     * Probably not implemented
     */
    @Override
    public boolean execute() {
        return true;
    }

    public void help(){
        System.out.println("look <target> -- not implemented");
    }
}
