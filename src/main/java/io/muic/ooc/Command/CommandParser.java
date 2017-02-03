package io.muic.ooc.Command;

import io.muic.ooc.Command.ActualCommand.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by wit on 1/12/2017 AD.
 */
public class CommandParser {
    public static HashMap<String, Command> commandsAvailable = new HashMap<String, Command>(){
        {
            put("attack",new Attack()); //done
            put("buy",new Buy()); //need to implement shop first
            put("defend",new Defend()); //done
            put("equipment",new Equipment()); //done
            put("go",new Go()); //next
            put("help",new Help()); //once all are done
            put("inventory",new Inventory()); // after go
            put("look",new Look()); //not going to be implemented
            put("map",new Map()); //after go
            put("quit",new Quit()); //done
            put("room",new RoomInformation()); //after map
            put("roominformation",new RoomInformation()); //after map
            put("sell",new Sell()); //need to implement shop
            put("stat",new Stat()); //after map
            put("talk",new Talk()); //need to implement proper npc first
            put("use",new Use()); //after map
        }
    };

    /**
     *
     * @param input --> from nextLine from scanner class
     * @return Command item or null value, null if not a valid Command
     */
    public static Command parseInput(String input){
        input = input.toLowerCase();
        String[] inputs = input.split(" ");
        Command cmd = commandsAvailable.getOrDefault(inputs[0],null);
        if (cmd != null){
            cmd.setArguments(inputsToArrayList(inputs,1));
        }
        return cmd;
    }

    /**
     * Turn the input into arguments for the Command to use
     * @param inputs
     * @param startLocation
     * @return
     */
    public static ArrayList<String> inputsToArrayList(String[] inputs, int startLocation){
        ArrayList<String> arr = new ArrayList<>();
        for (int i = startLocation; i < inputs.length; i++){
            arr.add(inputs[i]);
        }
        return arr;
    }
}
