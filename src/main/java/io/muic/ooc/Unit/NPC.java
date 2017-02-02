package io.muic.ooc.Unit;

import io.muic.ooc.Item.Item;

import java.util.ArrayList;

/**
 * Created by wit on 1/30/2017 AD.
 */
public abstract class NPC extends Unit{
    private boolean isAggro = false; //Will attack the player automatically if it is
    private int exp;

    public NPC(String name){
        super(name);
    }



    //Dropping loots
    public ArrayList<Item> dropLoots(){
        return getInventory();
    }




    public boolean isAggro() {
        return isAggro;
    }

    public void setAggro(boolean aggro) {
        isAggro = aggro;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
}
