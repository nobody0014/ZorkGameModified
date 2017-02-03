package io.muic.ooc.Item;

import java.util.HashMap;

/**
 * Created by wit on 2/1/2017 AD.
 */
public class EquipmentFactory {
    public enum EQUIPMENT_TYPE {WEAPON, ARMOR, GLOVE, PANT, SHOE;}
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

}
