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


    public Equipment(String name, EquipmentFactory.EQUIPMENT_TYPE equipment_type, int str, int con, int intel, int wis, int dex, int luck){
        super(name);
        this.equipment_type = equipment_type;
        this.extraStr = str;
        this.extraCon = con;
        this.extraInt = intel;
        this.extraWis = wis;
        this.extraDex = dex;
        this.extraLuck = luck;
        this.equipmentSlot = EquipmentFactory.EQUIPMENT_SLOT.get(this.equipment_type);
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
}
