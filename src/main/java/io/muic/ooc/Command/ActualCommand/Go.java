package io.muic.ooc.Command.ActualCommand;

import io.muic.ooc.Command.Command;
import io.muic.ooc.RoomAndLevel.Level;
import io.muic.ooc.RoomAndLevel.Room;
import io.muic.ooc.Unit.Player;

import java.util.List;

/**
 * Created by wit on 2/1/2017 AD.
 */
public class Go extends Command{

    @Override
    public boolean execute(){
        Level currrentLevel = getCurrentLevel();
        Room currentRoom = currrentLevel.getCurrentRoom();
        List<String> arguments = getArguments();
        if (arguments.size() > 0) {
            String destination = arguments.get(0);
            if(currentRoom.getExits().keySet().contains(destination)){
                currrentLevel.changeRoom(destination);
            }else if (currentRoom.getLevelExits().keySet().contains(destination)){
                currrentLevel.changeLevel(destination);
            }else {
                System.out.println("The specified destination does not exist");
            }
        }else{
            System.out.println("Did not specify destination");
        }
        return true;
    }

}
