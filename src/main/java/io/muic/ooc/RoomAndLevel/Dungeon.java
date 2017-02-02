package io.muic.ooc.RoomAndLevel;

import java.util.ArrayList;

/**
 * Created by wit on 1/31/2017 AD.
 */
public class Dungeon {
    boolean completionStatus = false;
    String dungeonName;
    ArrayList<Level> allLevel;
    int playerCurrentLevel;


    public String getDungeonName() {
        return dungeonName;
    }

    public void setDungeonName(String dungeonName) {
        this.dungeonName = dungeonName;
    }

    public ArrayList<Level> getAllLevel() {
        return allLevel;
    }

    public void setAllLevel(ArrayList<Level> allLevel) {
        this.allLevel = allLevel;
    }

    public int getPlayerCurrentLevel() {
        return playerCurrentLevel;
    }

    public void setPlayerCurrentLevel(int playerCurrentLevel) {
        this.playerCurrentLevel = playerCurrentLevel;
    }

    public boolean isCompletionStatus() {
        return completionStatus;
    }

    public void setCompletionStatus(boolean completionStatus) {
        this.completionStatus = completionStatus;
    }
}
