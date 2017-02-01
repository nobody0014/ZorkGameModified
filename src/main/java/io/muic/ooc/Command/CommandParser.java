package io.muic.ooc.Command;

/**
 * Created by wit on 1/12/2017 AD.
 */
public class CommandParser {
    public static Command parseInput(String input){
        Command cmd  = null;
        String[] inputs = input.split(" ");
        switch (inputs[0].toLowerCase()){
            case "help": //Done
                break;
            case "go":
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
            case "skill": //probably not gonna implement this at this time
                break;
            case "use":
                break;
            case "stat":
                break;
            case "inventory":
                break;
            case "equipment":
                break;
            case "map":
                break;
            case "look":
                break;
            case "room":
                break;
            case "quit":
                break;
            default:
                break;
        }

        return cmd;
    }
}
