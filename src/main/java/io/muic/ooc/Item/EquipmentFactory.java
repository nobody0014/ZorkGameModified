package io.muic.ooc.Item;

import java.util.*;

/**
 * Created by wit on 2/1/2017 AD.
 */
public class EquipmentFactory {
    public enum EQUIPMENT_TYPE {WEAPON, ARMOR, GLOVE, PANT, SHOE;}

    /**
     * these statics are used to do the equipment slot and such
     */
    public static final HashMap<EQUIPMENT_TYPE,Integer> EQUIPMENT_TYPE_INTEGER_HASH_MAP = new HashMap<EQUIPMENT_TYPE, Integer>(){
        {
            int i = 0;
            for (EQUIPMENT_TYPE et: EQUIPMENT_TYPE.values()){
                put(et,i);
                i++;
            }
        }
    };

    public static final HashMap<Integer,EQUIPMENT_TYPE> INTEGER_EQUIPMENT_TYPE_HASH_MAP = new HashMap<Integer, EQUIPMENT_TYPE>(){
        {
            int i = 0;
            for (EQUIPMENT_TYPE et: EQUIPMENT_TYPE.values()){
                put(i,et);
                i++;
            }
        }
    };

    public static List<String> equipmentNames  = Arrays.asList("excalibur","lightsaber","woolrobe");

    public static HashMap<String, Equipment> equipmentHashMap = new HashMap<String, Equipment>(){{
        put("excalibur", createExcalibur());
        put("lightsaber", createLightsaber());
        put("woolrobe", createWoolRobe());
    }};


    public static Equipment createExcalibur(){
        Equipment equipment = new Equipment("excalibur",EQUIPMENT_TYPE.WEAPON);
        equipment.setExtraStr(10);
        equipment.setExtraCon(10);
        equipment.setExtraPhysicalAttack(20);
        return equipment;
    }

    public static Equipment createLightsaber(){
        Equipment equipment = new Equipment("lightsaber",EQUIPMENT_TYPE.WEAPON);
        equipment.setExtraDex(30);
        equipment.setExtraLuck(10);
        equipment.setExtraPhysicalAttack(10);
        equipment.setExtraMagicalAttack(20);
        return equipment;
    }

    public static Equipment createWoolRobe(){
        Equipment equipment = new Equipment("woolrobe",EQUIPMENT_TYPE.ARMOR);
        equipment.setExtraInt(10);
        equipment.setExtraDex(20);
        equipment.setExtraLuck(10);
        equipment.setExtraPhysicalDefense(10);
        equipment.setExtraMagicalDefense(30);
        return equipment;
    }

    public static ArrayList<Equipment> createEquipments(int limit){
        ArrayList<Equipment> equipments = new ArrayList<>();
        Random rand = new Random();
        int no = rand.nextInt(limit);
        if (limit > 0){
            for (int i = 0; i < no; i++){
                String equipmentRandomed = equipmentNames.get(rand.nextInt(equipmentNames.size()));
                equipments.add(equipmentHashMap.get(equipmentRandomed));
            }
        }
        return equipments;
    }

}
