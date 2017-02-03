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

    @Override
    public boolean equals(Object object)
    {
        boolean sameSame = false;

        if (object != null && object instanceof Item) {
            sameSame = this.itemName.equals (((Item) object).itemName);
        }else if (object != null && object instanceof String){
            sameSame = this.itemName.equals(object);
        }
        return sameSame;
    }
}
