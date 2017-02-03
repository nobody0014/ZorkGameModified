package io.muic.ooc.Command.ActualCommand;

import io.muic.ooc.Calculator.DamageCalculator;
import io.muic.ooc.Command.Command;
import io.muic.ooc.Item.Item;
import io.muic.ooc.MainLoop.ZorkView;
import io.muic.ooc.RoomAndLevel.Level;
import io.muic.ooc.RoomAndLevel.Room;
import io.muic.ooc.Unit.MonsterFactory;
import io.muic.ooc.Unit.NPC;
import io.muic.ooc.Unit.Player;
import io.muic.ooc.Unit.Unit;

import java.util.ArrayList;

/**
 * Created by wit on 2/1/2017 AD.
 */
public class Attack extends Command{


    /**
     * Get the target NPC from the room and then do damage calculation, change health and others accordingly
     */
    @Override
    public boolean execute(){
        Level currentLevel = getCurrentLevel();
        Room currentRoom = currentLevel.getCurrentRoom();
        Player player = getPlayer();
        ArrayList<String> args = getArguments();

        if (args.size() > 0){
            try {
                Integer NPCNumber = Integer.parseInt(args.get(0));
                attack(player,currentRoom,NPCNumber);
            }catch (Exception e){
                attack(player,currentRoom,args.get(0));
            }
        }else {
            System.out.println("invalid input");
        }
        return true;
    }

    /**
     * if there are several NPC with the same name then use the earliest one
     * @param player
     * @param currentRoom
     * @param NPCName
     */
    public void attack(Player player, Room currentRoom, String NPCName){
        boolean npcExist = false;
        for (NPC npc: currentRoom.getNpcs()){
            if (npc.getUnitName().equals(NPCName)){
                npcExist = true;
                battleEvaluation(player,npc);
                break;
            }
        }
        if (npcExist){
            retaliation(player,currentRoom);
        }else{
            System.out.println("Target specified does not exist");
        }
    }

    /**
     * specified NPCNumber in the arraylist
     * @param player
     * @param currentRoom
     * @param NPCNumber
     */
    public void attack(Player player, Room currentRoom, int NPCNumber){
        if (currentRoom.getNpcs().size() > NPCNumber){
            battleEvaluation(player,currentRoom.getNpcs().get(NPCNumber));
        }else{
            System.out.println("Targeted NPC does not exist");
        }
    }


    /**
     * Do evaluation for the player and the NPC
     * @param player
     * @param npc
     */
    public void battleEvaluation(Player player, NPC npc){
        battleResult(player,npc);

        if (!npc.isAggro()){
            npc.setAggro(true);
        }

        if (!npc.isAlive()){
            npc.setAggro(false);
            ArrayList<Item> loots = npc.dropLoots();
            player.getInventory().addAll(loots);
            player.gainExp(npc.getExp());
            printGainLoot(npc);
            printGainExp(player,npc);
        }
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

    public void printGainExp(Player attacker, NPC defender){
        System.out.println(attacker.getUnitName() + " gain " + defender.getExp() + " exp from " + defender.getUnitName());
    }

    public void printGainLoot(Unit defender){
        StringBuilder toPrint = new StringBuilder();
        toPrint.append("Loot gain from " + defender.getUnitName() + ": ");
        if (defender.getInventory().size() > 0){
            for (Item loot : defender.getInventory()){
                toPrint.append(loot.getItemName() + " ");
            }
        }else {
            toPrint.append("nothing");
        }
        System.out.println(toPrint);
    }

    public void help(){
        System.out.println("Attack <target> -- only 1 target will be attacked, other specified target will not be attacked");
    }
}
