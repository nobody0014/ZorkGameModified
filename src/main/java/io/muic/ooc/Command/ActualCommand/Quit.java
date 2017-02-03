package io.muic.ooc.Command.ActualCommand;

import io.muic.ooc.Command.Command;
import io.muic.ooc.MainLoop.ZorkView;

/**
 * Created by wit on 2/1/2017 AD.
 */
public class Quit extends Command{

    /**
     * quit the game
     * @return the boolean result from confirmation
     */
    @Override
    public boolean execute() {
        boolean quitGame = !ZorkView.quitGame();
        return quitGame;
    }

    public void help(){
        System.out.println("quit -- quit the game");
    }
}
