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
            put("attack",new Attack());
            put("buy",new Buy());
            put("defend",new Defend());
            put("equipment",new Equipment());
            put("go",new Go());
            put("help",new Help());
            put("inventory",new Inventory());
            put("look",new Look());
            put("map",new Map());
            put("quit",new Quit());
            put("room",new RoomInformation());
            put("roominformation",new RoomInformation());
            put("sell",new Sell());
            put("stat",new Stat());
            put("talk",new Talk());
            put("use",new Use());
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
