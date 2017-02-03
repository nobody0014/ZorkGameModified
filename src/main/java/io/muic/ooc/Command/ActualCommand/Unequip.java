package io.muic.ooc.Command.ActualCommand;

import io.muic.ooc.Command.Command;
import io.muic.ooc.Item.*;
import io.muic.ooc.Unit.Player;

import java.util.List;

/**
 * Created by wit on 2/3/2017 AD.
 */
public class Unequip extends Command {
    public boolean execute(){
        Player player = getPlayer();
        List<String> arguments = getArguments();
        if (arguments.size() > 0){
            io.muic.ooc.Item.Equipment[] eqs = player.getEquipments();

        }else {
            System.out.println("User did not specify equipment");
        }
        return true;
    }

    public void help(){
        System.out.println("unequip <equipment> -- will unequip the equipment from your inventory slot");
    }
}
