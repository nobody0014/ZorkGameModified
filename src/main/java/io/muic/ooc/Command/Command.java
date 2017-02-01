package io.muic.ooc.Command;

import io.muic.ooc.RoomAndLevel.Level;
import io.muic.ooc.Unit.Player;

import java.util.ArrayList;

/**
 * Created by wit on 1/12/2017 AD.
 */
public abstract class Command  {
    Player player;
    Level currentLevel;
    ArrayList<String> arguments = null;

    public abstract boolean execute();

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setCurrentLevel(Level currentLevel) {
        this.currentLevel = currentLevel;
    }

    public ArrayList<String> getArguments() {
        return arguments;
    }

    public void setArguments(ArrayList<String> arguments) {
        this.arguments = arguments;
    }

    public Player getPlayer() {
        return player;
    }

    public Level getCurrentLevel() {
        return currentLevel;
    }
}
