package io.muic.ooc.Item;

import java.util.Enumeration;

/**
 * Created by wit on 1/12/2017 AD.
 */
public class Item {
    public enum  Type{WEAPON, CONSUMABLE}



    private int usage;
    private Type itemType;


    public Item(int usage, Type type ){}



    public void consume(){if (usage > -1){usage--;}}

    public int getUsage(){return usage;}
    public Type getItemType(){return itemType;}
}
