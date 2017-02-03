package io.muic.ooc.MainLoop;

import io.muic.ooc.Command.ActualCommand.Map;
import io.muic.ooc.Command.ActualCommand.RoomInformation;
import io.muic.ooc.Command.Command;
import io.muic.ooc.RoomAndLevel.Level;
import io.muic.ooc.RoomAndLevel.LevelFactory;
import io.muic.ooc.Unit.Player;

/**
 * Created by wit on 1/12/2017 AD.
 */
public class ZorkRunner {
    //Starting location and rooms
    private Player player;

    private Level currentLevel;

    public ZorkRunner(String name){
        player = new Player(name);
        currentLevel = LevelFactory.hub;
        Command cmd = new RoomInformation();
        cmd.setPlayer(player);
        cmd.setCurrentLevel(currentLevel);
        cmd.execute();
    }

    /**
     *
     * @param cmd from the result of the CommandParser
     * @return boolean value whether we should continue the game or not
     */
    public boolean executeCommand(Command cmd){
        cmd.setPlayer(player);
        cmd.setCurrentLevel(currentLevel);
        boolean toReturn  = cmd.execute();
        setCurrentLevel(cmd.getCurrentLevel());
        ZorkView.printFinishLine();
        return toReturn;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Level getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(Level currentLevel) {
        this.currentLevel = currentLevel;
    }
}
