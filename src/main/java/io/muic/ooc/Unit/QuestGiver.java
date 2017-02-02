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
    Dungeon[] dungeons;

    public QuestGiver(String name){
        super(name);
    }

    /**
     * give the quest, will look at the current level
     */
    public Quest getQuest(){
        return quests[questLevel];
    }

    public Dungeon getDungeon(){
        return dungeons[questLevel];
    }

    public void questDone(){
        questLevel++;
    }



    public void setQuests(Quest[] quests) {
        this.quests = quests;
    }

    public void setDungeons(Dungeon[] dungeons) {
        this.dungeons = dungeons;
    }
}
