package io.muic.ooc.Item;

import io.muic.ooc.MainLoop.ZorkView;

import java.util.HashMap;

/**
 * Created by wit on 2/1/2017 AD.
 */
public class Equipment extends Item{

    private EquipmentFactory.EQUIPMENT_TYPE equipment_type;

    private int equipmentSlot;

    private int extraStr;
    private int extraCon;
    private int extraInt;
    private int extraWis;
    private int extraDex;
    private int extraLuck;

    private int extraPhysicalAttack;
    private int extraPhysicalDefense;
    private int extraMagicalAttack;
    private int extraMagicalDefense;


    public Equipment(String name, EquipmentFactory.EQUIPMENT_TYPE equipment_type){
        super(name);
        this.equipment_type = equipment_type;
        this.equipmentSlot = EquipmentFactory.EQUIPMENT_TYPE_INTEGER_HASH_MAP.get(this.equipment_type);
    }

    public int getEquipmentSlot(){
        return equipmentSlot;
    }

    public EquipmentFactory.EQUIPMENT_TYPE getEquipment_type() {
        return equipment_type;
    }

    public int getExtraStr() {
        return extraStr;
    }

    public int getExtraCon() {
        return extraCon;
    }

    public int getExtraInt() {
        return extraInt;
    }

    public int getExtraWis() {
        return extraWis;
    }

    public int getExtraDex() {
        return extraDex;
    }

    public int getExtraLuck() {
        return extraLuck;
    }

    public int getExtraPhysicalAttack() {
        return extraPhysicalAttack;
    }

    public int getExtraPhysicalDefense() {
        return extraPhysicalDefense;
    }

    public int getExtraMagicalAttack() {
        return extraMagicalAttack;
    }

    public int getExtraMagicalDefense() {
        return extraMagicalDefense;
    }

    public void setEquipment_type(EquipmentFactory.EQUIPMENT_TYPE equipment_type) {
        this.equipment_type = equipment_type;
    }

    public void setEquipmentSlot(int equipmentSlot) {
        this.equipmentSlot = equipmentSlot;
    }

    public void setExtraStr(int extraStr) {
        this.extraStr = extraStr;
    }

    public void setExtraCon(int extraCon) {
        this.extraCon = extraCon;
    }

    public void setExtraInt(int extraInt) {
        this.extraInt = extraInt;
    }

    public void setExtraWis(int extraWis) {
        this.extraWis = extraWis;
    }

    public void setExtraDex(int extraDex) {
        this.extraDex = extraDex;
    }

    public void setExtraLuck(int extraLuck) {
        this.extraLuck = extraLuck;
    }

    public void setExtraPhysicalAttack(int extraPhysicalAttack) {
        this.extraPhysicalAttack = extraPhysicalAttack;
    }

    public void setExtraPhysicalDefense(int extraPhysicalDefense) {
        this.extraPhysicalDefense = extraPhysicalDefense;
    }

    public void setExtraMagicalAttack(int extraMagicalAttack) {
        this.extraMagicalAttack = extraMagicalAttack;
    }

    public void setExtraMagicalDefense(int extraMagicalDefense) {
        this.extraMagicalDefense = extraMagicalDefense;
    }
}
