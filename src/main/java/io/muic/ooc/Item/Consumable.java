package io.muic.ooc.Item;

/**
 * Created by wit on 2/1/2017 AD.
 */
public class Consumable extends Item {

    private int giveHealth;
    private int giveMana;


    public Consumable(String name, int giveHealth, int giveMana){
        super(name);
        this.giveHealth = giveHealth;
        this.giveMana = giveMana;
    }

    public int getGiveHealth() {
        return giveHealth;
    }

    public int getGiveMana() {
        return giveMana;
    }
}
