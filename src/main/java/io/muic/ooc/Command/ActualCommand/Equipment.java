package io.muic.ooc.Command.ActualCommand;

import io.muic.ooc.Command.Command;
import io.muic.ooc.RoomAndLevel.Level;
import io.muic.ooc.RoomAndLevel.Room;
import io.muic.ooc.Unit.Player;

import java.util.ArrayList;

/**
 * Created by wit on 2/1/2017 AD.
 */
public class Equipment extends Command {

    /**
     * Print out the equipment the player is currently equipping
     */
    @Override
    public boolean execute(){
        Level currentLevel = getCurrentLevel();
        Room currentRoom = currentLevel.getCurrentRoom();
        Player player = getPlayer();
        ArrayList<String> args = getArguments();

        for (int i = 0; i< player.getEquipments().length; i++){
            printDetailedEquipment(player.getEquipments()[i]);
        }
        return true;
    }

    public void printDetailedEquipment(io.muic.ooc.Item.Equipment eq){
        System.out.println(eq.getEquipment_type() + ": " + eq.getItemName() + " ,strength: "  + eq.getExtraStr()
        + " ,constitution: "  + eq.getExtraCon() + " ,dexterity: "  + eq.getExtraDex() + " ,luck: "  + eq.getExtraLuck()
                + " ,intelligence: "  + eq.getExtraStr() + " ,wisdom: " + eq.getExtraWis());
    }

    public void help(){
        System.out.println("equipment --> give the current information of players current equipment");
    }
}
