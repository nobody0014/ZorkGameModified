package io.muic.ooc.RoomAndLevel;

import java.util.ArrayList;

/**
 * Created by wit on 1/31/2017 AD.
 */
public class Dungeon {
    String dungeonName;
    ArrayList<Level> allLevel;

    public Dungeon(String name){
        this.dungeonName = name;
        this.allLevel = new ArrayList<>();
    }

    public void addLevel(Level level){
        this.allLevel.add(level);
    }

    public void enter(){}

    public void leave(){}

    public void changeLevel(){}

    public void changeRoom(){}
}
