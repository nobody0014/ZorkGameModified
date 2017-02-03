package io.muic.ooc.Command.ActualCommand;

import io.muic.ooc.Command.Command;

/**
 * Created by wit on 2/1/2017 AD.
 */
public class Sell extends Command{

    @Override
    public boolean execute() {
        //Possible only when there's shop NPC in the room
        //Take item from the player and sell it
        return true;
    }

    public void help(){
        System.out.println("Sell <item> -- not implemented");
    }
}
