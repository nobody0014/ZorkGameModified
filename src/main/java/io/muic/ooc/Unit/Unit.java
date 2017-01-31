package io.muic.ooc.Unit;

import io.muic.ooc.Calculator.StatCalculator;
import io.muic.ooc.Item.Item;
import io.muic.ooc.Skill.Skill;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wit on 1/24/2017 AD.
 */
public abstract class Unit {

    private boolean isAlive;


    private String unitName;

    private int level;
    private int baseStr;
    private int baseDex;
    private int baseInt;
    private int baseWis;
    private int baseCon;
    private int baseLuck;

    //Stats for battle --> base stat will be used to calculate them
    private int currentHp;
    private int currentMana;
    private int maxHp;
    private int maxMana;

    private float physicalAttack;
    private float physicalDenfense;
    private float magicalAttack;
    private float magicalDefense;
    private float accuracy;
    private float dodgeChance;
    private float criticalChance;
    private float criticalDefense;


    //Bag
    private ArrayList<Item> inventory;


    public void gainHp(int hp) {
        if (getCurrentHp() + hp > getMaxHp()) {
            setCurrentHp(getMaxHp());
        } else {
            setCurrentHp(getCurrentHp() + hp);
        }
    }

    public void loseHp(int hp) {
        setCurrentHp(getCurrentHp() - hp);
        if (getCurrentHp() <= 0) {
            setAlive(false);
        }
    }

    //Called when there's a change in level or change in base stat, it will calculate other stat that in used in battle
    public void updateStatus() {

        setPhysicalAttack(StatCalculator.calculatePhysicalAttack(getBaseStr(), getBaseDex()));
        setPhysicalDenfense(StatCalculator.calculatePhysicalDefense(getBaseStr(), getBaseCon()));
        setMagicalAttack(StatCalculator.calculateMagicalAttack(getBaseInt(), getBaseDex()));
        setMagicalDefense(StatCalculator.calculateMagicalDefense(getBaseInt(), getBaseCon()));
//        setAccuracy();
//        setDodgeChance();
//        setCriticalChance();
//        setMaxHp();
//        setMaxMana();
    }


    public void die() {
    }


    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getBaseStr() {
        return baseStr;
    }

    public void setBaseStr(int baseStr) {
        this.baseStr = baseStr;
    }

    public int getBaseDex() {
        return baseDex;
    }

    public void setBaseDex(int baseDex) {
        this.baseDex = baseDex;
    }

    public int getBaseInt() {
        return baseInt;
    }

    public void setBaseInt(int baseInt) {
        this.baseInt = baseInt;
    }

    public int getBaseWis() {
        return baseWis;
    }

    public void setBaseWis(int baseWis) {
        this.baseWis = baseWis;
    }

    public int getBaseCon() {
        return baseCon;
    }

    public void setBaseCon(int baseCon) {
        this.baseCon = baseCon;
    }

    public int getBaseLuck() {
        return baseLuck;
    }

    public void setBaseLuck(int baseLuck) {
        this.baseLuck = baseLuck;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }

    public int getCurrentMana() {
        return currentMana;
    }

    public void setCurrentMana(int currentMana) {
        this.currentMana = currentMana;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public float getPhysicalAttack() {
        return physicalAttack;
    }

    public void setPhysicalAttack(float physicalAttack) {
        this.physicalAttack = physicalAttack;
    }

    public float getPhysicalDenfense() {
        return physicalDenfense;
    }

    public void setPhysicalDenfense(float physicalDenfense) {
        this.physicalDenfense = physicalDenfense;
    }

    public float getMagicalAttack() {
        return magicalAttack;
    }

    public void setMagicalAttack(float magicalAttack) {
        this.magicalAttack = magicalAttack;
    }

    public float getMagicalDefense() {
        return magicalDefense;
    }

    public void setMagicalDefense(float magicalDefense) {
        this.magicalDefense = magicalDefense;
    }

    public float getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(float accuracy) {
        this.accuracy = accuracy;
    }

    public float getDodgeChance() {
        return dodgeChance;
    }

    public void setDodgeChance(float dodgeChance) {
        this.dodgeChance = dodgeChance;
    }

    public float getCriticalChance() {
        return criticalChance;
    }

    public void setCriticalChance(float criticalChance) {
        this.criticalChance = criticalChance;
    }


    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public float getCriticalDefense() {
        return criticalDefense;
    }

    public void setCriticalDefense(float criticalDefense) {
        this.criticalDefense = criticalDefense;
    }
}
