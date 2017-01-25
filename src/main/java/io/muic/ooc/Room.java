package io.muic.ooc;

import io.muic.ooc.Item.Item;
import io.muic.ooc.Unit.Monster;

import java.util.*;

/**
 * Created by wit on 1/12/2017 AD.
 */
public class Room {
    private final static int MAX_ITEMS = 3;

    private List<Item> items = new ArrayList<Item>();

    private Monster monster = null;

    private Map<String, Room> exitMap = null;


    public boolean addItem(Item item){
        if (items.size() < MAX_ITEMS){
            this.items.add(item);
            return true;
        }

        return false;
    }

    public String getInfo(){
        //print items
        //print monster
        //print exits
        return "TODO";
    }

    public void setMonster(Monster monster) {
        if (monster != null){
            this.monster = monster;
        }
    }

    public void setExitMap(String direction, Room exitingRoom){
        if (direction.equals("north") || direction.equals("south") || direction.equals("east") || direction.equals("west")){
            exitMap.put(direction,exitingRoom);
        }else{System.out.println("Invalid direction");}
    }
}
