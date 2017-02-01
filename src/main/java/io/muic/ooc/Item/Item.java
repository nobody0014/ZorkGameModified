package io.muic.ooc.Item;

import java.util.Enumeration;

/**
 * Created by wit on 1/12/2017 AD.
 */
public abstract class Item {
    private String itemName;

    public Item(String itemName){
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }
}
