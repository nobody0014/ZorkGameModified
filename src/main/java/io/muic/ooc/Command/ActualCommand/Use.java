package io.muic.ooc.Command.ActualCommand;

import io.muic.ooc.Command.Command;
import io.muic.ooc.Item.Consumable;
import io.muic.ooc.Item.Item;
import io.muic.ooc.Unit.Player;

import java.util.List;

/**
 * Created by wit on 2/1/2017 AD.
 */
public class Use extends Command {

    /**
     * Use the consumable if possible --> works only with consumable
     */
    @Override
    public boolean execute() {
        List<String> arguments = getArguments();
        Player player = getPlayer();
        List<Item> inventory = player.getInventory();

        if (arguments.size() > 0){
            if (inventory.contains(arguments.get(0))){
                try{
                    Integer slot = Integer.parseInt(arguments.get(0));
                    if (slot < inventory.size() && slot >= 0){
                        if (inventory.get(slot) instanceof Consumable){
                            Consumable consumable = (Consumable) inventory.get(slot);
                            int healHp = consumable.getGiveHealth();
                            int healMana = consumable.getGiveMana();
                            player.gainHp(healHp);
                            player.gainMana(healMana);
                            inventory.remove(consumable);
                            System.out.println("Consume " + consumable.getItemName() + " to gain " + consumable.getGiveHealth()
                                    + " hp and " +consumable.getGiveMana() + " mana."  );
                        }else {
                            System.out.println("Item selected is not a consumable");
                        }
                    }else {
                        System.out.println("You did not have the item");
                    }
                }catch (Exception e){
                    System.out.println("The argument for use has to be the number that is shown in the inventory.");
                }
            }else{
                System.out.println("No such item in the inventory");
            }
        }else {
            System.out.println("You did not give the item to use");
        }
        return true;
    }

    public void help(){
        System.out.println("use <consumable> -- use the consumable in the inventory");
    }
}
