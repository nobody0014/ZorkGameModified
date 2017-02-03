package io.muic.ooc.Quest;

import io.muic.ooc.Item.*;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by wit on 2/3/2017 AD.
 */
public class QuestFactory {

    public static Quest createFirstQuest(){
        Quest quest = new Quest("reclaim the forest");
        quest.setCompleteStatus(false);
        quest.setGiven(false);
        quest.setRewardObtained(false);
        quest.setQuestPossibleLocations((ArrayList<String>) Arrays.asList("forest"));
        quest.setQuestRewardExp(200);
        quest.setQuestRewardItem((ArrayList<Item>) Arrays.asList(EquipmentFactory.createExcalibur(), ConsumableFactory.createLevelOneHealthPotion()));
        return quest;
    }
}
