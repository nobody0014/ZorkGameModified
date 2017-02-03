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
//            for (String arg: arguments){
//                if (currentRoom.getItems().contains(arg)){
//                    int i = currentRoom.getItems().indexOf(arg);
//                    Item item = currentRoom.getItems().get(i);
//                    currentRoom.getItems().remove(i);
//                    player.addItemToInventory(item);
//                    System.out.println("Picked up " + arg + " successfully.");
//                }else {
//                    System.out.println("There is no " + arg + " to pick up.");
//                }
//            }
            try{
                Integer slot = Integer.parseInt(arguments.get(0));
                if (slot < currentRoom.getItems().size() && slot >= 0){
                    Item item = currentRoom.getItems().get(slot);
                    currentRoom.getItems().remove(item);
                    player.addItemToInventory(item);
                    System.out.println("Picked up " + item.getItemName() + " successfully.");
                }
            }catch (Exception e){
                System.out.println("The argument for picking item has to be the number that is shown in the room information.");
            }
        }else{
            System.out.println("Did not specified which loot to pick up");
        }
        return  true;
    }

    public void help(){
        System.out.println("pickup/take <itemslot in the room> -- take item (consumable/weapon... etc) in the current room");
    }
}
