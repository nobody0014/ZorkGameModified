package io.muic.ooc.Command.ActualCommand;

import io.muic.ooc.Command.Command;

/**
 * Created by wit on 2/1/2017 AD.
 */
public class Sell extends Command{
    String itemName;

    public Sell(String itemName){
        this.itemName = itemName;
    }

    @Override
    public void execute() {
        //Possible only when there's shop NPC in the room
        //Take item from the player and sell it
    }
}
