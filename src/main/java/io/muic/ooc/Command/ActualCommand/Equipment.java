package io.muic.ooc.Command.ActualCommand;

import io.muic.ooc.Command.Command;
import io.muic.ooc.Item.EquipmentFactory;
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
        Player player = getPlayer();
        for (int i = 0; i< player.getEquipments().length; i++){
            io.muic.ooc.Item.Equipment eq = player.getEquipments()[i];
            if (player.getEquipments()[i] != null){
                System.out.println(eq.getEquipment_type() + ": " + eq.getItemName() + " ,strength: "  + eq.getExtraStr()
                        + " ,constitution: "  + eq.getExtraCon() + " ,dexterity: "  + eq.getExtraDex() + " ,luck: "  + eq.getExtraLuck()
                        + " ,intelligence: "  + eq.getExtraStr() + " ,wisdom: " + eq.getExtraWis());
            }else {
                System.out.println(EquipmentFactory.INTEGER_EQUIPMENT_TYPE_HASH_MAP.get(i) + ": None");
            }
        }
        return true;
    }

    public void help(){
        System.out.println("equipment -- give the current information of players current equipment");
    }
}
