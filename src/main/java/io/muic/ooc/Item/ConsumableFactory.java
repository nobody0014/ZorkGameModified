package io.muic.ooc.Item;

import java.util.*;

/**
 * Created by wit on 2/1/2017 AD.
 */
public class ConsumableFactory {
    public static List<String> consumableNames  = Arrays.asList("low health potion","low mana potion");

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
        if (limit > 0){
            Random rand = new Random();
            int no = rand.nextInt(limit);
            for (int i = 0; i < no; i++){
                String consumableRandomed = consumableNames.get(rand.nextInt(consumableNames.size()));
                if (consumableRandomed.equals("low health potion")){
                    consumables.add(createLevelOneHealthPotion());
                }else if(consumableRandomed.equals("low mana potion")){
                    consumables.add(createLevelOneManaPotion());
                }
            }
        }
        return consumables;
    }
}
