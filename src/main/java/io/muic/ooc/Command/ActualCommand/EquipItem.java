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

            try{
                Integer slot = Integer.parseInt(arguments.get(0));
                if (slot < inventory.size() && slot >= 0){
                    Item item = inventory.get(slot);
                    inventory.remove(item);
                    player.addItemToInventory(item);
                    player.equip(arguments.get(0));
                    System.out.println("You have equipped " + item.getItemName());
                }else {
                    System.out.println("You did not have the item");
                }
            }catch (Exception e){
                System.out.println("The argument for equipitem has to be the number that is shown in the inventory.");
            }
        }else {
            System.out.println("Did not specfied the item to equip");
        }
        return true;
    }
    public void help(){
        System.out.println("equipItem <item slot in the inventory> -- equip the equipment in the inventory");
    }
}
