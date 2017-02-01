package io.muic.ooc.Quest;

import io.muic.ooc.Item.Item;
import io.muic.ooc.Unit.Monster;

import java.util.HashMap;

/**
 * Created by wit on 2/1/2017 AD.
 */
public class Quest {
    String questName;
    boolean completeStatus = false;

    HashMap<Monster, Integer> targetMonsters = null;
    HashMap<Item, Integer> targetItems = null;

    HashMap<Monster, Integer> monstersCompletion = null;
    HashMap<Item, Integer> itemsCompletion = null;


    public Quest(String questName){
        this.questName = questName;
    }

    public void setMonstersCompletion(HashMap<M onster,Integer> monstersCompletion){
        this.monstersCompletion = monstersCompletion;
    }

    public void setItemsCompletion(HashMap<Item,Integer> itemsCompletion){
        this.itemsCompletion = itemsCompletion;
    }

    public void setTargetMonsters(HashMap<Monster, Integer>  targetMonsters){
        this.targetMonsters = targetMonsters;
    }

    public void setTargetItems(HashMap<Item, Integer> targetItems){
        this.targetItems = targetItems;
    }



}
