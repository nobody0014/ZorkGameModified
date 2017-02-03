package io.muic.ooc.Command.ActualCommand;

import io.muic.ooc.Command.Command;
import io.muic.ooc.RoomAndLevel.Level;
import io.muic.ooc.RoomAndLevel.LevelFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wit on 2/3/2017 AD.
 */
public class Reset extends Command {
    public boolean execute(){
        Level currentLevel = getCurrentLevel();
        Set<String> destinations = currentLevel.getCurrentRoom().getLevelExits().keySet();
        if (getArguments().size() > 0){
            if (destinations.contains(getArguments().get(0))){
                String levelName = getArguments().get(0);
                currentLevel.getCurrentRoom().getLevelExits().put(levelName, LevelFactory.levelHashMap.get(levelName));
            }else {
                System.out.println("The target level is not available from this room");
            }
        }else {
            System.out.println("No reset target was given");
        }
        return true;
    }

    public void help(){
        System.out.println("reset <target> -- randomly reset the target level.");
    }
}
