package io.muic.ooc.Command.ActualCommand;

import io.muic.ooc.Command.Command;

/**
 * Created by wit on 2/1/2017 AD.
 */
public class Buy extends Command{
    String itemName;

    public Buy(String itemName){
        this.itemName = itemName;
    }

    @Override
    public void execute() {
        //Possible only when there's shop NPC in the room
        //buy the item from the NPC
    }
}
