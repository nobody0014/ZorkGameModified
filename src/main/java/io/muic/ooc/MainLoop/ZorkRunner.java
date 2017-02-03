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
    //Main hub--> probably the best i can do for it... cant afford to be throwing it everywhere
    public static Level hubLevel = LevelFactory.createHubLevel();


    //Starting location and rooms
    private Player player;

    private Level currentLevel;

    public ZorkRunner(String name){
        player = new Player(name);
        currentLevel = hubLevel;
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
        return cmd.execute();
    }

}
