package io.muic.ooc.Calculator;

import io.muic.ooc.Skill.Skill;
import io.muic.ooc.Unit.Player;
import io.muic.ooc.Unit.Unit;

import java.util.Random;

/**
 * Created by wit on 1/24/2017 AD.
 */
public class DamageCalculator {

    public static int calculateDamage(Unit attacker, Unit defender){
        attacker.updateStatus();
        defender.updateStatus();
        float possibleDamage = attacker.getPhysicalAttack() - defender.getPhysicalDenfense();
        float possibleCrit  = attacker.getCriticalChance() - attacker.getCriticalDefense();
        float possibleDodge = attacker.getAccuracy() - defender.getDodgeChance();
        Random random = new Random();
        if (possibleDamage <= 0 && possibleDamage != -1){
            possibleDamage = 1;
        }
        if (possibleDodge < random.nextInt(100)){
            return -1;
        }else {
            if (possibleCrit > random.nextInt(100)){
                System.out.println("Critical Damage!");
                return (int)possibleDamage*3;
            }else {
                return (int)possibleDamage;
            }
        }
    }
}
