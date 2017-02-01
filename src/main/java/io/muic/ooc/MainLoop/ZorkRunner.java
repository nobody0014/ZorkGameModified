package io.muic.ooc.MainLoop;

import io.muic.ooc.RoomAndLevel.Level;
import io.muic.ooc.RoomAndLevel.LevelFactory;
import io.muic.ooc.Unit.Player;

/**
 * Created by wit on 1/12/2017 AD.
 */
public class ZorkRunner {

    //Starting location and rooms
    private Player player;

    private Level hubLevel;

    private Level currentLevel;

    public ZorkRunner(String name){
        player = new Player(name);
        hubLevel = LevelFactory.createHubLevel();
        currentLevel = hubLevel;
        ZorkView.printRoomDetail(currentLevel);
    }

    public boolean executeCommand(String[] inputs){
        boolean continueGame = true;
        boolean commandSuccess = false;


        return continueGame;
    }


    //return true if the command succeeded in moving
    private boolean go(String direction){
        boolean validMovement;
        if(direction.equals("north") || direction.equals("south") || direction.equals("east") || direction.equals("west")){
            //Change the room in the roomLevel
            validMovement = currentLevel.changeRoom(direction);
        }else{
            Level newLevel = currentLevel.changeLevel(direction);
            if (newLevel == null){
                return false;
            }
            currentLevel = newLevel;
            validMovement = true;
        }
        return validMovement;
    }


    private void talk(String NPCName){

    }
    private void buy(String itemName){

    }
    private void sell(String itemName){

    }
}
