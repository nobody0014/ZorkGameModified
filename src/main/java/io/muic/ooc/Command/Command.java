package io.muic.ooc.Command;

import io.muic.ooc.RoomAndLevel.Level;
import io.muic.ooc.Unit.Player;

/**
 * Created by wit on 1/12/2017 AD.
 */
public abstract class Command  {
    Player player;
    Level currentLevel;

    public void setUpCommand(Player player, Level currentLevel){
        this.currentLevel = currentLevel;
        this.player = player;
    };

    public abstract void execute();

    public Player getPlayer() {
        return player;
    }

    public Level getCurrentLevel() {
        return currentLevel;
    }
}
