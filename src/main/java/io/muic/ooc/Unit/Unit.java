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

    private boolean isAlive = true;


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
    private ArrayList<Item> inventory = new ArrayList<>();

    public Unit(String name){
        setUnitName(name);
    }

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

    public void gainMana(int mana) {
        if (getCurrentMana() + mana > getMaxMana()) {
            setCurrentHp(getMaxMana());
        } else {
            setCurrentHp(getCurrentMana() + mana);
        }
    }

    public void fillHP(){
        setCurrentHp(getMaxHp());
    }

    public void fillMana(){
        setCurrentHp(getMaxMana());
    }

    @Override
    public boolean equals(Object object)
    {
        boolean sameSame = false;

        if (object != null && object instanceof Unit) {
            sameSame = this.unitName.equals(((Unit) object).unitName);
        }else if (object != null && object instanceof String){
            sameSame = this.unitName.equals(object);
        }
        return sameSame;
    }


    //Called when there's a change in level or change in base stat, it will calculate other stat that in used in battle
    public void updateStatus() {
        setPhysicalAttack(StatCalculator.calculatePhysicalAttack(getBaseStr(), getBaseDex()));
        setPhysicalDenfense(StatCalculator.calculatePhysicalDefense(getBaseStr(), getBaseCon()));
        setMagicalAttack(StatCalculator.calculateMagicalAttack(getBaseInt(), getBaseDex()));
        setMagicalDefense(StatCalculator.calculateMagicalDefense(getBaseInt(), getBaseCon()));
        setAccuracy(StatCalculator.calculateAccuracy(getBaseDex(),getBaseLuck()));
        setDodgeChance(StatCalculator.calculateDodgeChance(getBaseDex(),getBaseLuck()));
        setCriticalChance(StatCalculator.calculateCriticalChance(getBaseDex(),getBaseLuck()));
        setMaxHp(StatCalculator.calculateMaxHp(getBaseStr(),getBaseCon()));
        setMaxMana(StatCalculator.calculateMaxMana(getBaseInt(),getBaseWis()));
    }

    public void printInformation(){
        System.out.println("Unit name: " + getUnitName());
        System.out.println("Current Level: " + getLevel());
        System.out.println("Current HP: " + getCurrentHp() + "/" + getMaxHp());
        System.out.println("Current Mana: " + getCurrentMana() + "/" + getMaxMana());
    }


    public void addItemToInventory(Item item){
        getInventory().add(item);
    }

    public boolean isAlive() {
        return isAlive;
    }

    private void setAlive(boolean alive) {
        isAlive = alive;
    }

    public int getLevel() {
        return level;
    }

    protected void setLevel(int level) {
        this.level = level;
    }

    public int getBaseStr() {
        return baseStr;
    }

    protected void setBaseStr(int baseStr) {
        this.baseStr = baseStr;
    }

    public int getBaseDex() {
        return baseDex;
    }

    protected void setBaseDex(int baseDex) {
        this.baseDex = baseDex;
    }

    public int getBaseInt() {
        return baseInt;
    }

    protected void setBaseInt(int baseInt) {
        this.baseInt = baseInt;
    }

    public int getBaseWis() {
        return baseWis;
    }

    protected void setBaseWis(int baseWis) {
        this.baseWis = baseWis;
    }

    public int getBaseCon() {
        return baseCon;
    }

    protected void setBaseCon(int baseCon) {
        this.baseCon = baseCon;
    }

    public int getBaseLuck() {
        return baseLuck;
    }

    protected void setBaseLuck(int baseLuck) {
        this.baseLuck = baseLuck;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    protected void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }

    public int getCurrentMana() {
        return currentMana;
    }

    protected void setCurrentMana(int currentMana) {
        this.currentMana = currentMana;
    }

    public int getMaxHp() {
        return maxHp;
    }

    protected void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getMaxMana() {
        return maxMana;
    }

    protected void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public float getPhysicalAttack() {
        return physicalAttack;
    }

    protected void setPhysicalAttack(float physicalAttack) {
        this.physicalAttack = physicalAttack;
    }

    public float getPhysicalDenfense() {
        return physicalDenfense;
    }

    protected void setPhysicalDenfense(float physicalDenfense) {
        this.physicalDenfense = physicalDenfense;
    }

    public float getMagicalAttack() {
        return magicalAttack;
    }

    protected void setMagicalAttack(float magicalAttack) {
        this.magicalAttack = magicalAttack;
    }

    public float getMagicalDefense() {
        return magicalDefense;
    }

    protected void setMagicalDefense(float magicalDefense) {
        this.magicalDefense = magicalDefense;
    }

    public float getAccuracy() {
        return accuracy;
    }

    protected void setAccuracy(float accuracy) {
        this.accuracy = accuracy;
    }

    public float getDodgeChance() {
        return dodgeChance;
    }

    protected void setDodgeChance(float dodgeChance) {
        this.dodgeChance = dodgeChance;
    }

    public float getCriticalChance() {
        return criticalChance;
    }

    protected void setCriticalChance(float criticalChance) {
        this.criticalChance = criticalChance;
    }


    public String getUnitName() {
        return unitName;
    }

    protected void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public float getCriticalDefense() {
        return criticalDefense;
    }

    protected void setCriticalDefense(float criticalDefense) {
        this.criticalDefense = criticalDefense;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }
}
