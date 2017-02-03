package io.muic.ooc.Command.ActualCommand;

import io.muic.ooc.Command.Command;
import io.muic.ooc.Item.Item;
import io.muic.ooc.Unit.Player;

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
        for (int i = 0; i < inventory.size(); i++){
            System.out.println(i + ") " + inventory.get(i).getItemName());
        }
        return true;
    }
}
