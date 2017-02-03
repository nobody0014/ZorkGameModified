package io.muic.ooc.Item;

import java.util.*;

/**
 * Created by wit on 2/1/2017 AD.
 */
public class ConsumableFactory {
    public static List<String> consumableNames  = Arrays.asList("LevelOneHealthPotion","LevelOneManaPotion");

    public static HashMap<String, Consumable> consumableHashMap= new HashMap<String, Consumable>(){{
        put("LevelOneHealthPotion", createLevelOneHealthPotion());
        put("LevelOneManaPotion", createLevelOneManaPotion());
    }};


    public static Consumable createLevelOneHealthPotion(){
        Consumable potion = new Consumable("low health potion", 20, 0);
        return potion;
    }

    public static Consumable createLevelOneManaPotion(){
        Consumable potion = new Consumable("low mana potion", 0, 10);
        return potion;
    }

    public static ArrayList<Consumable> createConsumables(int limit){
        ArrayList<Consumable> consumables = new ArrayList<>();
        Random rand = new Random();
        if (limit > 0){
            int no = rand.nextInt(limit);
            for (int i = 0; i < no; i++){
                String consumableRandomed = consumableNames.get(rand.nextInt(consumableNames.size()));
                consumables.add(consumableHashMap.get(consumableRandomed));
            }
        }

        return consumables;
    }
}
