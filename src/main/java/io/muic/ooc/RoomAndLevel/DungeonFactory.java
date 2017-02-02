package io.muic.ooc.RoomAndLevel;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by wit on 1/31/2017 AD.
 */
public class DungeonFactory {
    public Dungeon createHubDungeon(){
        Dungeon hub = new Dungeon();

        hub.setDungeonName("hub");
        hub.setPlayerCurrentLevel(0);

        ArrayList<Level> allLevels = new ArrayList<>();

        Level level1 = LevelFactory.createHubLevel();
        allLevels.add(level1);

        hub.setAllLevel(allLevels);

        return hub;
    }

    public Dungeon createForestDungeon(){
        Dungeon forest  = new Dungeon();

        forest.setDungeonName("forest");
//        ArrayList<Level>





        return forest;
    }
}
