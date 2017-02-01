package io.muic.ooc.Command.ActualCommand;

import io.muic.ooc.Command.Command;

import java.util.ArrayList;

/**
 * Created by wit on 2/1/2017 AD.
 */
public class Stat extends Command {
    private ArrayList<String> NPCNames = new ArrayList<>();


    public void addNPCNames(String NPCName){
        this.NPCNames.add(NPCName);
    }

    /**
     * Print the stat of the player, however, if the NPCNames are given then do both in order
     * For the NPCName that does not exist, simply print out does not exist in the end
     */
    @Override
    public void execute() {

    }
}
