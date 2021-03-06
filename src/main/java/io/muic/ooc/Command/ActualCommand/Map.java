package io.muic.ooc.Command.ActualCommand;

import io.muic.ooc.Command.Command;
import io.muic.ooc.MainLoop.ZorkView;
import io.muic.ooc.RoomAndLevel.Level;
import io.muic.ooc.RoomAndLevel.Room;
import io.muic.ooc.Unit.Player;

import java.util.ArrayList;

/**
 * Created by wit on 2/1/2017 AD.
 */
public class Map extends Command{

    /**
     * print out the current map and location
     */
    @Override
    public boolean execute() {
        Level currentLevel = getCurrentLevel();
        printOutCurrentMap(currentLevel);
        return true;
    }

    public void printOutCurrentMap(Level currentLevel){
        int  size  = currentLevel.getSize();
        Room[][] map = currentLevel.getRooms();
        StringBuilder toPrint = new StringBuilder();
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                Room r = map[j][i];
                if (r == null){
                    toPrint.append(" ,");
                }else if(i == currentLevel.getPlayerX() && j == currentLevel.getPlayerY() ){
                    toPrint.append("P,");
                } else if(r.isVisited()){
                    toPrint.append("V,");
                }else{
                    toPrint.append("R,");
                }
            }
            toPrint.deleteCharAt(toPrint.length()-1);
            toPrint.append("\n");
        }
        System.out.println(toPrint);
        ZorkView.printFinishLine();
    }

    public void help(){
        System.out.println("map -- show the map of the current level");
    }
}
