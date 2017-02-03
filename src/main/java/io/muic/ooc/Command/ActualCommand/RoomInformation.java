package io.muic.ooc.Command.ActualCommand;

import io.muic.ooc.Command.Command;
import io.muic.ooc.Item.Item;
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
        Level currentLevel = getCurrentLevel();
        Room currentRoom = currentLevel.getCurrentRoom();
        List<NPC> npcs = currentRoom.getNpcs();
        List<Item> loots = currentRoom.getItems();
        Set<String> roomExits = currentRoom.getExits().keySet();
        Set<String> levelExits  = currentRoom.getLevelExits().keySet();

        System.out.println("Level Name: " + currentLevel.getLevelName());
        System.out.println("Room Location: " + currentRoom.getRoomX() + " " + currentRoom.getRoomY());
        System.out.println("List of NPC (in order): ");
        Collections.sort(npcs, (o1,o2) -> {
                if (o1.getClass().toString().compareTo(o2.getClass().toString()) != 0){
                    return o1.getClass().toString().compareTo(o2.getClass().toString());
                }else{
                    return o1.getUnitName().compareTo(o2.getUnitName());
                }
        });
        for (int i = 0; i < npcs.size(); i++){
            System.out.println(i + ") " + npcs.get(i).getUnitName());
        }
        System.out.println("List of available loots for pick up:");
        for (int i = 0; i < loots.size(); i++){
            System.out.println(i + ") " + loots.get(i).getItemName());
        }

        System.out.println("Available Room Exits: ");
        for (String exit: roomExits){
            if (currentRoom.getExits().get(exit).isVisited()){
                System.out.println(exit + ": visited");
            }else {
                System.out.println(exit + ": not visited");
            }
        }

        System.out.println("Available Level Room Exits: ");
        for (String exit: levelExits){
            System.out.println(exit);
        }
        return true;
    }

}
