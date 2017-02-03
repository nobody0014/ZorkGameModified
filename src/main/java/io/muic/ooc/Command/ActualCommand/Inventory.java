package io.muic.ooc.Command.ActualCommand;

import io.muic.ooc.Command.Command;
import io.muic.ooc.Item.Item;
import io.muic.ooc.Unit.Player;

import java.util.Collections;
import java.util.List;

/**
 * Created by wit on 2/1/2017 AD.
 */
public class Inventory extends Command {

    /**
     * Print out the inventory of the player
     */
    @Override
    public boolean execute() {
        Player player = getPlayer();
        List<Item> inventory = player.getInventory();
        System.out.println("Player current inventory: ");
        Collections.sort(inventory,(o1,o2) -> {
            if (o1.getClass().toString().compareTo(o2.getClass().toString()) != 0){
                return o1.getClass().toString().compareTo(o2.getClass().toString());
            }else{
                return o1.getItemName().compareTo(o2.getItemName());
            }
        });
        for (int i = 0; i < inventory.size(); i++){
            System.out.println(i + ") " + inventory.get(i).getItemName());
        }
        return true;
    }

    public void help(){
        System.out.println("inventory -- printing out the information of the equipment of the player");
    }
}
