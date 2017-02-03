package io.muic.ooc.Command.ActualCommand;

import io.muic.ooc.Calculator.DamageCalculator;
import io.muic.ooc.Command.Command;
import io.muic.ooc.RoomAndLevel.Level;
import io.muic.ooc.RoomAndLevel.Room;
import io.muic.ooc.Unit.NPC;
import io.muic.ooc.Unit.Player;
import io.muic.ooc.Unit.Unit;

import java.util.ArrayList;

/**
 * Created by wit on 2/1/2017 AD.
 */
public class Defend extends Command{

    /**
     * Increase the defense temporarily
     */
    @Override
    public boolean execute() {
        Level currentLevel = getCurrentLevel();
        Room currentRoom = currentLevel.getCurrentRoom();
        Player player = getPlayer();
        ArrayList<String> args = getArguments();

        player.setExtraPhysicalDefense(10);
        player.setExtraMagicalDefense(10);
        retaliation(player,currentRoom);
        return true;
    }

    public void retaliation(Player player, Room currentRoom){
        for (NPC npc: currentRoom.getNpcs()){
            if (npc.isAggro()){
                battleResult(npc,player);
            }
        }
    }

    public void battleResult(Unit attacker, Unit defender){
        int damageDelt = DamageCalculator.calculateDamage(attacker,defender);
        if (damageDelt > -1){
            defender.loseHp(damageDelt);
            printDealDamage(attacker,defender,damageDelt);
        }else {
            printMissAttack(attacker);
        }
    }

    public void printDealDamage(Unit attacker, Unit defender, int damageDelt){
        System.out.println(attacker.getUnitName() + " deal " + damageDelt + " to " + defender.getUnitName());
    }

    public void printMissAttack(Unit attacker){
        System.out.println(attacker.getUnitName() + "'s attack miss");
    }

    public void help(){
        System.out.println("defend -- temporarily increase the defense of the upcoming attacks");
    }
}
