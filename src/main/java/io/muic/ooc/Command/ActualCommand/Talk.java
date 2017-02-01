package io.muic.ooc.Command.ActualCommand;

import io.muic.ooc.Command.Command;

/**
 * Created by wit on 2/1/2017 AD.
 */
public class Talk extends Command{
    String NPCName;

    public Talk(String targetedNPCName){
        this.NPCName = targetedNPCName;
    }

    public void execute(){
        //get the NPC... do talk to the person
        //Get quest if we are given it
    }
}
