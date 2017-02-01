package io.muic.ooc.Command.ActualCommand;

import io.muic.ooc.Command.Command;
import io.muic.ooc.RoomAndLevel.Level;
import io.muic.ooc.Unit.Player;

/**
 * Created by wit on 2/1/2017 AD.
 */
public class Go extends Command{
    String destination;

    public Go(String destination){
        setDestination(destination.toLowerCase());
    }

    public void execute(){

//        if (this.destination.equals("north") || this.destination.equals("south") || this.destination.equals("east") ||
//                this.destination.equals("west")){
//
//        }else {
//
//        }
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
