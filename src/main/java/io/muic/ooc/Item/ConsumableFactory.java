package io.muic.ooc.Item;

/**
 * Created by wit on 2/1/2017 AD.
 */
public class ConsumableFactory {
    public static Consumable createLevelOneHealthPotion(){
        Consumable potion = new Consumable("low health potion", 20, 0);
        return potion;
    }

    public static Consumable createLevelOneManaPotion(){
        Consumable potion = new Consumable("low mana potion", 0, 10);
        return potion;
    }
}
