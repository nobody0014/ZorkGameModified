package io.muic.ooc.Command.ActualCommand;

import io.muic.ooc.Command.Command;
import io.muic.ooc.Unit.Player;

import java.util.ArrayList;

/**
 * Created by wit on 2/1/2017 AD.
 */
public class Stat extends Command {

    /**
     * Print the stat of the player, however, if the NPCNames are given then do both in order
     * For the NPCName that does not exist, simply print out does not exist in the end
     */
    @Override
    public boolean execute() {
        Player player = getPlayer();
        System.out.println("Health: " + player.getCurrentHp() + "/" + player.getMaxHp() + "     Mana: " +
                player.getCurrentMana() + "/" + player.getMaxMana() + "     Exp: " + player.getCurrentExp()
                + "/" + player.getMaxExp());
        System.out.println("Strength: " + (player.getBaseStr() + player.getExtraStr()));
        System.out.println("Constitution: " + (player.getBaseCon() + player.getExtraCon()));
        System.out.println("Dexterity: " + (player.getBaseDex() + player.getExtraDex()));
        System.out.println("Luck: " + (player.getBaseLuck() + player.getExtraLuck()));
        System.out.println("Intelligence: " + (player.getBaseInt() + player.getExtraInt()));
        System.out.println("Wisdom: " + (player.getBaseWis() + player.getExtraWis()));
        System.out.println("Physical Attack: " + (player.getPhysicalAttack() + player.getExtraPhysicalAttack()));
        System.out.println("Physical Defense: " + (player.getPhysicalDenfense() + player.getExtraPhysicalDefense()));
        System.out.println("Magical Attack: " + (player.getMagicalAttack() + player.getExtraMagicalAttack()));
        System.out.println("Magical Defense: " + (player.getMagicalDefense() + player.getExtraMagicalDefense()));
        System.out.println("Accuracy: " + (player.getAccuracy()));
        System.out.println("Dodge Chance: " + (player.getDodgeChance()));
        System.out.println("Critical Defense: " + (player.getCriticalDefense()));
        System.out.println("Critical Chance: " + (player.getCriticalChance()));
        return true;
    }

    public void help(){
        System.out.println("stat -- tell the stat of the player");
    }
}
