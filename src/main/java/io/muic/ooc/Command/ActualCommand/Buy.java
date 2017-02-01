package io.muic.ooc.Command.ActualCommand;

import io.muic.ooc.Command.Command;

/**
 * Created by wit on 2/1/2017 AD.
 */
public class Buy extends Command{

    @Override
    public boolean execute() {
        //Possible only when there's shop NPC in the room
        //buy the item from the NPC

        return true;
    }
}
