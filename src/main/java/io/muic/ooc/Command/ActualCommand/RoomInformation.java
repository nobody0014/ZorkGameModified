package io.muic.ooc.Command.ActualCommand;

import io.muic.ooc.Command.Command;
import io.muic.ooc.Item.Item;
import io.muic.ooc.MainLoop.ZorkView;
import io.muic.ooc.RoomAndLevel.Level;
import io.muic.ooc.RoomAndLevel.Room;
import io.muic.ooc.Unit.NPC;
import io.muic.ooc.Unit.Player;

import java.util.*;

/**
 * Created by wit on 2/1/2017 AD.
 */

public class RoomInformation extends Command{

    /**
     * print out the information of the current room
     */
    @Override
    public boolean execute() {
        ZorkView.printCurrentRoomInformation(getCurrentLevel());
        return true;
    }

    public void help(){
        System.out.println("room/roominformation -- give the informtion of the current room... this is the same as when you enter another room");
    }
}
