package io.muic.ooc.Unit;

import io.muic.ooc.Quest.Quest;
import io.muic.ooc.RoomAndLevel.Dungeon;
import io.muic.ooc.RoomAndLevel.Level;

import java.util.ArrayList;

/**
 * Created by wit on 1/31/2017 AD.
 */
public class QuestGiver extends NPC {

    //Will give first level quest
    public int questLevel = 1;

    Quest[] quests;

    public QuestGiver(String name){
        super(name);
    }


    public Quest getQuest(){
        if (questLevel < quests.length){
            return quests[questLevel];
        }else {
            return  null;
        }

    }

    public void questDone(){
        questLevel++;
    }

    public void setQuests(Quest[] quests) {
        this.quests = quests;
    }

}
