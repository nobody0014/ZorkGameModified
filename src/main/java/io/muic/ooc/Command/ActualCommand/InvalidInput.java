package io.muic.ooc.Command.ActualCommand;

import io.muic.ooc.Command.Command;

/**
 * Created by wit on 2/3/2017 AD.
 */
public class InvalidInput extends Command {
    public boolean execute(){
        System.out.println("Unable to evaluate the command.type \'help\' for the command list");
        return true;
    }
    public void help(){
        System.out.println("created when invalid commands are received");
    }
}
