package io.muic.ooc.Unit;

import java.util.List;

/**
 * Created by wit on 1/12/2017 AD.
 */
public class Monster extends NPC{
    private int rarity;

    public Monster(String name){
        super(name);
    }

    public int getRarity() {
        return rarity;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    @Override
    public int getExp() {
        return super.getExp()*rarity;
    }
}
