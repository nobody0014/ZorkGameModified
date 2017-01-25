package io.muic.ooc.Unit;

import io.muic.ooc.Skill.Skill;

import java.util.List;

/**
 * Created by wit on 1/24/2017 AD.
 */
public abstract class Unit {
    private int level;
    private int baseStr = 5;
    private int baseDex = 5;
    private int baseInt = 5;
    private int baseWis = 5;
    private int baseCon = 5;

    private int currentHp;
    private int currentMana;
    private int maxHp;
    private int maxMana;

    private int physicalAttack;
    private int physicalDenfense;
    private int magicalAttack;
    private int magicalDefense;
    private float dodgeChance;
    private float criticalChance;


    public void attack() {
    }

    public void attack(Skill skill) {
    }

    public boolean isDead() {
        if (currentHp <= 0)
            return true;
        else
            return false;
    }

}
