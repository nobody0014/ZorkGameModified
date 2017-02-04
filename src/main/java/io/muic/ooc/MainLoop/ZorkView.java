package io.muic.ooc.MainLoop;

import io.muic.ooc.Item.Item;
import io.muic.ooc.RoomAndLevel.Room;
import io.muic.ooc.RoomAndLevel.Level;
import io.muic.ooc.Unit.NPC;

import java.io.InputStream;
import java.util.*;

/**
 * Created by wit on 1/30/2017 AD.
 */
public class ZorkView {
    public static InputStream input = System.in;

    public static void askUserName(){
        System.out.println("Please Enter your player name: ");
    }

    public static void printFinishLine(){
        System.out.println("----------------------------\n");
    }

    public static void printHelp(){
        System.out.println("go <direction/place you want to as long as it is valid>");
        System.out.println("talk <NPC> -Works even on monster but you are wasting your turn, unless they aren't aggroed yet\n" +
                "talking to a shop NPC will gives you the item list available for buying ");
        System.out.println("buy <ItemName> -Works as long as NPC of shop type is in the same room");
        System.out.println("sell <ItemName> -Works as long as NPC of shop type is in the same room");
        System.out.println("attack <NPCName> -If the NPC is not aggroed yet then there will be a confirmation button");
        System.out.println("defend -increase the defend of the player till the next command input");
        System.out.println("skill <SkillName> <NPCName> -use a skill on NPC");
        System.out.println("use <Consumable> -will use the consumable on yourself");
        System.out.println("stat <-optional NPCName in the same room> - look at your own stat or specified NPC");
        System.out.println("map -give the map of the level");
        System.out.println("look -show the detail of the current room");
        System.out.println("pick <ItemName> -pick up the item in the room");
        System.out.println();
    }

    public static void printCurrentRoomInformation(Level currentLevel){
        Room currentRoom = currentLevel.getCurrentRoom();
        List<NPC> npcs = currentRoom.getNpcs();
        List<Item> loots = currentRoom.getItems();
        Set<String> roomExits = currentRoom.getExits().keySet();
        Set<String> levelExits = currentRoom.getLevelExits().keySet();

        System.out.println("Level Name: " + currentLevel.getLevelName());
        System.out.println("Room Location: " + currentRoom.getRoomX() + " " + currentRoom.getRoomY());
        System.out.println("List of NPC (in order): ");
        Collections.sort(npcs, (o1, o2) -> {
            if (o1.getClass().toString().compareTo(o2.getClass().toString()) != 0){
                return o1.getClass().toString().compareTo(o2.getClass().toString());
            }else{
                return o1.getUnitName().compareTo(o2.getUnitName());
            }
        });
        for (int i = 0; i < npcs.size(); i++){
            System.out.println(i + ") " + npcs.get(i).getUnitName() + "  hp:" + npcs.get(i).getCurrentHp() + "/" +npcs.get(i).getMaxHp());
        }
        System.out.println("List of available loots for pick up:");
        for (int i = 0; i < loots.size(); i++){
            System.out.println(i + ") " + loots.get(i).getItemName());
        }

        System.out.println("Available Room Exits: ");
        for (String exit: roomExits){
            if (currentRoom.getExits().get(exit).isVisited()){
                System.out.println(exit + ": visited");
            }else {
                System.out.println(exit + ": not visited");
            }
        }

        System.out.println("Available Level Room Exits: ");
        for (String exit: levelExits){
            System.out.println(exit);
        }
    }

    public static boolean quitGame(){
        System.out.println("Are you sure you want to quit? (y/n)");
        return confirmation();
    }

    public static boolean confirmation(){
        Scanner scanner = new Scanner(input);
        boolean toReturn = false;
        while (true){
            String ans = scanner.next();
            if (ans.equals("y")){
                toReturn = true;
                System.out.println("You have chosen to quit the game.");
                break;
            }
            else if (ans.equals("n")){
                System.out.println("You have chosen not to quit the game.");
                break;
            }else{
                System.out.println("Invalid Command: Please answer y or n");
            }
        }
        printFinishLine();
        return toReturn;
    }
}
