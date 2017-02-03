package io.muic.ooc.Command.ActualCommand;

import io.muic.ooc.Command.Command;
import io.muic.ooc.Item.Item;
import io.muic.ooc.Unit.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wit on 2/3/2017 AD.
 */
public class EquipItem extends Command {
    public boolean execute(){
        Player player = getPlayer();
        List<Item> inventory  = player.getInventory();
        List<String> arguments  = getArguments();
        if (arguments.size() > 0){
            if (inventory.contains(arguments.get(0))){
                player.equip(arguments.get(0));
                System.out.println("You have equipped " + arguments.get(0));
            }else {
                System.out.println("You did not have the item");
            }
        }else {
            System.out.println("Did not specfied the item to equip");
        }
        return true;
    }
}
