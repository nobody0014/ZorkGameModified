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
            //DONE: Attack,Defend,Equipment,Map,Quit,RoomInformation,Stat,EquipItem,PickUpItem,Go,Inventory,Use
            //IMPLEMENTING:
            //NEED FIX: DamageCalculator
            //NOT DONE: Help
            //NOT GOING TO IMPLEMENT: Look,Buy,Sell, talk


            put("attack",new Attack());
            put("defend",new Defend());

//            put("buy",new Buy());
//            put("sell",new Sell());
            put("use",new Use());

            put("go",new Go());
//            put("talk",new Talk());

            put("stat",new Stat());
            put("map",new Map());
            put("inventory",new Inventory());
            put("room",new RoomInformation());
            put("roominformation",new RoomInformation());

            put("increasestat" ,new IncreaseStat());
            put("equip", new EquipItem());
            put("equipment",new Equipment());

            put("take", new PickUpItem());
            put("pick", new PickUpItem());
            put("pickup", new PickUpItem());

            put("help",new Help());
            put("quit",new Quit());
//            put("look",new Look());

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
        Command cmd = commandsAvailable.getOrDefault(inputs[0],new InvalidInput());
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
