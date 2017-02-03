package io.muic.ooc.Unit;

import io.muic.ooc.Calculator.StatCalculator;
import io.muic.ooc.Item.Equipment;
import io.muic.ooc.Item.Item;
import io.muic.ooc.Quest.Quest;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by wit on 1/12/2017 AD.
 */
public class Player extends Unit {

    private int statPoints = 0;

    private int currentExp;
    private int maxExp;

    //For equipped items
    private int extraStr = 0;
    private int extraDex = 0;
    private int extraInt = 0;
    private int extraWis = 0;
    private int extraCon = 0;
    private int extraLuck = 0;

    private int extraPhysicalAttack = 0;
    private int extraPhysicalDefense = 0;
    private int extraMagicalAttack = 0;
    private int extraMagicalDefense = 0;

    private ArrayList<Quest> currentQuests = new ArrayList<>();
    private ArrayList<Quest> completedQuests = new ArrayList<>();

    private Equipment[] equipments = new Equipment[5];

    public Player(String name){
        super(name);
        setLevel(1);
        setBaseCon(5);
        setBaseDex(5);
        setBaseInt(5);
        setBaseLuck(5);
        setBaseStr(5);
        setBaseDex(5);
        setCurrentExp(0);
        updateStatus();
        fillHP();
        fillMana();
    }


    /**
     * update the status by looking at the base stat
     */
    @Override
    public void updateStatus(){
        setPhysicalAttack(StatCalculator.calculatePhysicalAttack(getBaseStr(), getBaseDex(),getExtraPhysicalAttack()));
        setPhysicalDenfense(StatCalculator.calculatePhysicalDefense(getBaseStr(), getBaseCon(),getExtraPhysicalDefense()));
        setMagicalAttack(StatCalculator.calculateMagicalAttack(getBaseInt(), getBaseDex(),getExtraMagicalAttack()));
        setMagicalDefense(StatCalculator.calculateMagicalDefense(getBaseInt(), getBaseCon(),getExtraMagicalDefense()));
        setAccuracy(StatCalculator.calculateAccuracy(getBaseDex(),getBaseLuck()));
        setDodgeChance(StatCalculator.calculateDodgeChance(getBaseDex(),getBaseLuck()));
        setCriticalChance(StatCalculator.calculateCriticalChance(getBaseDex(),getBaseLuck()));
        setMaxHp(StatCalculator.calculateMaxHp(getBaseStr(),getBaseCon()));
        setMaxMana(StatCalculator.calculateMaxMana(getBaseInt(),getBaseWis()));
        setMaxExp(StatCalculator.calculateMaxExp(getLevel()));
    }






    //Equipment
    /**
     * take item name and then used
     * @param itemName
     * @return
     */
    public boolean equip(String itemName) {
        boolean success = false;
        for (Item item: getInventory()){
            if (item.getItemName().equals(itemName) && item instanceof Equipment){
                Equipment eq = (Equipment) item;
                equipItem(eq,eq.getEquipmentSlot());
                success = true;
                break;
            }
        }
        return success;
    }
    /**
     * Overloaded version of equip.. this time using the arrangement of inverntory
     * @param inventorySlot
     * @return
     */
    public boolean equip(int inventorySlot) {
        boolean success = false;
        if (!(getInventory().size() < inventorySlot) || !(inventorySlot >= 0)){
            if (getInventory().get(inventorySlot) instanceof Equipment){
                Equipment eq = (Equipment) getInventory().get(inventorySlot);
                equipItem(eq, eq.getEquipmentSlot());
                success = true;
            }
        }
        return success;
    }



    //Quest Doing
    public void addNewQuest(Quest q){
        this.currentQuests.add(q);
    }
    public void completeQuest(Quest q){
        this.currentQuests.remove(q);
        this.completedQuests.add(q);
    }


    //Leveling
    /**
     * usually will be called by others
     * @param expGain
     */
    public void gainExp(int expGain){
        setCurrentExp(getCurrentExp() + expGain);
        if (getCurrentExp() >= getMaxExp()){
            setCurrentExp(getCurrentExp() - getMaxExp());
            levelUp();
            //Print level up
        }
    }
    /**
     * increase level, increase stat points, refill hp and mana
     */
    private void levelUp(){
        setLevel(getLevel()+1);
        setCurrentHp(getMaxHp());
        setCurrentMana(getMaxMana());
        setStatPoints(getStatPoints()+10);
    }
    /**
     * place equipment in the desired slot and return the equipment that was replaced --> null if there's none
     * @param equipment
     * @param slot
     * @return
     */
    private void equipItem(Equipment equipment, int slot){
        Equipment toReturn = null;
        if (equipments[slot] != null){
            toReturn = equipments[slot];
        }
        if (toReturn != null){
            addItemToInventory(toReturn);
        }
        equipments[slot] = equipment;
    }


    @Override
    public void printInformation(){
        super.printInformation();
    }



    public boolean increaseStr(){
        if (getStatPoints() > 0){
            incrementBaseStr();
            decrementStatPoints();
            return true;
        }else{
            return false;
        }
    }

    public boolean increaseCon(){
        if (getStatPoints() > 0){
            incrementBaseCon();
            decrementStatPoints();
            return true;
        }else{
            return false;
        }
    }

    public boolean increaseWis(){
        if (getStatPoints() > 0){
            incrementBaseWis();
            decrementStatPoints();
            return true;
        }else{
            return false;
        }
    }
    public boolean increaseInt(){
        if (getStatPoints() > 0){
            incrementBaseInt();
            decrementStatPoints();
            return true;
        }else{
            return false;
        }
    }
    public boolean increaseDex(){
        if (getStatPoints() > 0){
            incrementBaseDex();
            decrementStatPoints();
            return true;
        }else{
            return false;
        }
    }
    public boolean increaseLuck(){
        if (getStatPoints() > 0){
            incrementBaseLuck();
            decrementStatPoints();
            return true;
        }else{
            return false;
        }
    }

    private void incrementBaseStr(){setBaseStr(getBaseStr()+1);}

    private void incrementBaseCon(){setBaseCon(getBaseCon()+1);}

    private void incrementBaseInt(){setBaseInt(getBaseInt()+1);}

    private void incrementBaseLuck(){setBaseLuck(getBaseLuck()+1);}

    private void incrementBaseWis(){setBaseWis(getBaseWis()+1);}

    private void incrementBaseDex(){setBaseDex(getBaseDex()+1);}

    private void decrementStatPoints(){setStatPoints(getStatPoints()-1);}

    public int getCurrentExp() {
        return currentExp;
    }

    private void setCurrentExp(int currentExp) {
        this.currentExp = currentExp;
    }

    public int getMaxExp() {
        return maxExp;
    }

    private void setMaxExp(int maxExp) {
        this.maxExp = maxExp;
    }

    public int getExtraStr() {
        return extraStr;
    }

    public void setExtraStr(int extraStr) {
        this.extraStr = extraStr;
    }

    public int getExtraDex() {
        return extraDex;
    }

    public void setExtraDex(int extraDex) {
        this.extraDex = extraDex;
    }

    public int getExtraInt() {
        return extraInt;
    }

    public void setExtraInt(int extraInt) {
        this.extraInt = extraInt;
    }

    public int getExtraWis() {
        return extraWis;
    }

    public void setExtraWis(int extraWis) {
        this.extraWis = extraWis;
    }

    public int getExtraCon() {
        return extraCon;
    }

    public void setExtraCon(int extraCon) {
        this.extraCon = extraCon;
    }

    public int getExtraLuck() {
        return extraLuck;
    }

    public void setExtraLuck(int extraLuck) {
        this.extraLuck = extraLuck;
    }

    public int getStatPoints() {return statPoints;}

    public void setStatPoints(int statPoints) {this.statPoints = statPoints;}

    public int getExtraPhysicalAttack() {
        return extraPhysicalAttack;
    }

    public void setExtraPhysicalAttack(int extraPhysicalAttack) {
        this.extraPhysicalAttack = extraPhysicalAttack;
    }

    public int getExtraPhysicalDefense() {
        return extraPhysicalDefense;
    }

    public void setExtraPhysicalDefense(int extraPhysicalDefense) {
        this.extraPhysicalDefense = extraPhysicalDefense;
    }

    public int getExtraMagicalAttack() {
        return extraMagicalAttack;
    }

    public void setExtraMagicalAttack(int extraMagicalDamage) {
        this.extraMagicalAttack = extraMagicalDamage;
    }

    public int getExtraMagicalDefense() {
        return extraMagicalDefense;
    }

    public void setExtraMagicalDefense(int extraMagicalDefense) {
        this.extraMagicalDefense = extraMagicalDefense;
    }

    public Equipment[] getEquipments() {
        return equipments;
    }

    public void setEquipments(Equipment[] equipments) {
        this.equipments = equipments;
    }
}

