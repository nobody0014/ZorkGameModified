package io.muic.ooc.Quest;

import io.muic.ooc.Item.Item;
import io.muic.ooc.Unit.Monster;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by wit on 2/1/2017 AD.
 */
public class Quest {
    String questName;
    boolean completeStatus = false;
    boolean rewardObtained = false;

    HashMap<String, Integer> targetMonsters = null;
    HashMap<String, Integer> targetItems = null;

    HashMap<String, Integer> monstersCompletion = null;
    HashMap<String, Integer> itemsCompletion = null;

    int questRewardExp;
    ArrayList<Item> questRewardItem;


    public Quest(String questName){
        this.questName = questName;
    }




    /**
     * updatable only if the quest is not completed
     * @param monsterName
     * @param playerInventory
     */
    public void update(String monsterName, ArrayList<Item> playerInventory){
        if (!this.completeStatus){
            updateItemCompletion(playerInventory);
            updateMonsterCompletion(monsterName);
            updateQuestStatus();
        }
    }

    private void updateQuestStatus(){
        boolean completed = true;
        for (String monsterName: monstersCompletion.keySet()){
            if (!(monstersCompletion.get(monsterName) >= targetMonsters.get(monsterName))){
                completed = false;
            }
        }
        for (String itemName: itemsCompletion.keySet()){
            if (!(itemsCompletion.get(itemName) >= targetItems.get(itemName))){
                completed = false;
            }
        }
        setCompleteStatus(completed);
    }
    /**
     * reset the status of completion before updating it
     * @param playerInventory
     */
    private void updateItemCompletion(ArrayList<Item> playerInventory){
        for (String itemName: itemsCompletion.keySet()){
            itemsCompletion.put(itemName,0);
        }
        for (Item item: playerInventory){
            String itemName = item.getItemName();
            if (itemsCompletion.containsKey(itemName) && itemsCompletion.get(itemName) < targetItems.get(itemName)){
                itemsCompletion.put(itemName, itemsCompletion.get(itemName));
            }
        }
    }

    private void updateMonsterCompletion(String monsterName){
        if (monstersCompletion.containsKey(monsterName) && monstersCompletion.get(monsterName) < targetMonsters.get(monsterName)){
            monstersCompletion.put(monsterName, monstersCompletion.get(monsterName)+1);
        }
    }

    public boolean isCompleteStatus() {
        return completeStatus;
    }

    public void setCompleteStatus(boolean completeStatus) {
        this.completeStatus = completeStatus;
    }

    public HashMap<String, Integer> getTargetMonsters() {
        return targetMonsters;
    }

    public HashMap<String, Integer> getTargetItems() {
        return targetItems;
    }

    public HashMap<String, Integer> getMonstersCompletion() {
        return monstersCompletion;
    }

    public HashMap<String, Integer> getItemsCompletion() {
        return itemsCompletion;
    }

    public int getQuestRewardExp() {
        return questRewardExp;
    }

    public void setQuestRewardExp(int questRewardExp) {
        this.questRewardExp = questRewardExp;
    }

    public ArrayList<Item> getQuestRewardItem() {
        return questRewardItem;
    }

    public void setQuestRewardItem(ArrayList<Item> questRewardItem) {
        this.questRewardItem = questRewardItem;
    }

    public boolean isRewardObtained() {
        return rewardObtained;
    }

    public void setRewardObtained(boolean rewardObtained) {
        this.rewardObtained = rewardObtained;
    }
}
