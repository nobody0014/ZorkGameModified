package io.muic.ooc.MainLoop;

import io.muic.ooc.RoomAndLevel.Room;
import io.muic.ooc.RoomAndLevel.Rooms;
import io.muic.ooc.RoomAndLevel.RoomsFactory;
import io.muic.ooc.Unit.Player;

import java.util.ArrayList;

/**
 * Created by wit on 1/12/2017 AD.
 */
public class ZorkRunner {

    //Starting location and rooms
    private Player player = new Player();

    private Rooms hubRooms = RoomsFactory.createHubLevel();

    private Rooms currentRooms = hubRooms;

    public boolean executeCommand(String[] inputs){
        boolean continueGame = true;
        boolean commandSuccess = false;
        switch (inputs[0].toLowerCase()){
            case "help": //Done
                ZorkView.printHelp();
                break;
            case "go": //next
                if (inputs.length == 2){
                    commandSuccess = go(inputs[1]);
                }
                break;
            case "talk":
                break;
            case "buy":
                break;
            case "sell":
                break;
            case "attack":
                break;
            case "defend":
                break;
            case "skill":
                break;
            case "use":
                break;
            case "stat":
                break;
            case "map":
                break;
            case "look":
                break;
            case "room":
                break;
            case "quit":
                continueGame = !ZorkView.quitGame();
                break;
            default:
                ZorkView.printInvalidCommand();
                break;
        }
        if (!commandSuccess){
            System.out.println("Unable to execute command successfully");
        }
        return continueGame;
    }


    //return true if the command succeeded in moving
    private boolean go(String direction){
        boolean validMovement;
        if(direction.equals("north") || direction.equals("south") || direction.equals("east") || direction.equals("west")){
            //Change the room in the roomLevel
            validMovement = currentRooms.changeRoom(direction);
        }else{
            Rooms newLevel = currentRooms.changeLevel(direction);
            if (newLevel == null){
                return false;
            }

            currentRooms = newLevel;
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

//    private void room(){
//        currentRooms.getCurrentRoom()
//    }
}
