package io.muic.ooc.Unit;

import io.muic.ooc.RoomAndLevel.Level;

/**
 * Created by wit on 1/31/2017 AD.
 */
public class QuestGiver extends NPC {
    public int questLevel = 1;

    public QuestGiver(String name){
        super(name);
    }

    public void talk(){}

    /**
     * unlock new Level (Dungeon)
     */
    public Level getQuest(){
        return null;
    }

}
