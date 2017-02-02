package io.muic.ooc.Unit;

import java.util.HashMap;

/**
 * Created by wit on 1/12/2017 AD.
 */
public class MonsterFactory {
    public static final HashMap<Integer,String> ALL_MONSTER_NAME = new HashMap<Integer,String>(){
        {
            put(0, "goblin");
            put(1, "elf");
            put(2, "wolf");
            put(3, "orc");
        }
    };
    public static final HashMap<Integer,String> FOREST_MONSTER_NAME = new HashMap<Integer,String>(){
        {
            put(0, "goblin");
            put(1, "elf");
            put(2, "wolf");
            put(3, "orc");
        }
    };
}
