package io.muic.ooc.Item;

import java.util.HashMap;

/**
 * Created by wit on 2/1/2017 AD.
 */
public class EquipmentFactory {
    public enum EQUIPMENT_TYPE {WEAPON, ARMOR, GLOVE, PANT, SHOE;}
    public static final HashMap<EQUIPMENT_TYPE,Integer> EQUIPMENT_SLOT = createEQUIPMENT_SLOT();

    public static HashMap<EQUIPMENT_TYPE,Integer> createEQUIPMENT_SLOT(){
        HashMap<EQUIPMENT_TYPE,Integer> eq = new HashMap<>();
        int i = 0;
        for (EQUIPMENT_TYPE et: EQUIPMENT_TYPE.values()){
            eq.put(et,i);
            i++;
        }
        return eq;
    }

}
