package io.muic.ooc.Command.ActualCommand;

import io.muic.ooc.Command.Command;
import io.muic.ooc.Item.Item;
import io.muic.ooc.RoomAndLevel.Room;
import io.muic.ooc.Unit.Player;

import java.util.List;

/**
 * Created by wit on 2/3/2017 AD.
 */
public class PickUpItem extends Command {
    public boolean execute(){
        Player player = getPlayer();
        Room currentRoom = getCurrentLevel().getCurrentRoom();
        List<String> arguments = getArguments();
        if (arguments.size() > 0){
            for (String arg: arguments){
                if (currentRoom.getItems().contains(arg)){
                    int i = currentRoom.getItems().indexOf(arg); //first instance
                    Item item = currentRoom.getItems().get(i);
                    currentRoom.getItems().remove(i);
                    player.addItemToInventory(item);
                    System.out.println("Picked up " + arg + " successfully.");
                }else {
                    System.out.println("There is no " + arg + " to pick up.");
                }
            }
        }else{
            System.out.println("Did not specified which loot to pick up");
        }
        return  true;
    }

    public void help(){
        System.out.println("pickup/take <item> -- take item (consumable/weapon... etc) in the current room");
    }
}
