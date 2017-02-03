package io.muic.ooc.Unit;

import java.util.List;

/**
 * Created by wit on 1/12/2017 AD.
 */
public class Monster extends NPC{
    private int rarity;

    public Monster(String name, int str, int con, int intel, int wis, int dex, int luck, int rarity){
        super(name);
        setBaseStr(str);
        setBaseCon(con);
        setBaseInt(intel);
        setBaseWis(wis);
        setBaseDex(dex);
        setBaseLuck(luck);
        setRarity(rarity);
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
