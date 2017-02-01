package io.muic.ooc.Command.ActualCommand;

import io.muic.ooc.Command.Command;

/**
 * Created by wit on 2/1/2017 AD.
 */
public class Attack extends Command{
    String targetName;

    public Attack(String targetName){
        this.targetName = targetName;
    }

    /**
     * Get the target NPC from the room and then do damage calculation, change health and others accordingly
     */
    public void execute(){
    }
}
