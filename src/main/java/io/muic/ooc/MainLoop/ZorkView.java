package io.muic.ooc.MainLoop;

import io.muic.ooc.RoomAndLevel.Room;

import java.util.Scanner;

/**
 * Created by wit on 1/30/2017 AD.
 */
public class ZorkView {

    public static void askUserName(){
        System.out.println("Please Enter your player name: ");
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



    public static void printInvalidCommand(){
        System.out.println("The input command is invalid");
    }

    public static void printInvalidItemPlayer(){
        System.out.println("Specified item does not exist in the player's bag");
    }

    public static void printInvalidItemShop(){
        System.out.println("Specified item doesn not exist in the shop");
    }

    public static void printInvalidPick(){
        System.out.println("Item/Skill specified does not exist in the current room");
    }

    public static void printInvalidAttack(){
        System.out.println("The specified NPC does not exists to be attacked");
    }

    public static void invalidSkill(){
        System.out.println("There's no such skill available");
    }

    public static void invalidStat(){
        System.out.println("There's no such NPC available");
    }

    public static void invalidConsumable(){
        System.out.println("There's no such consumable in your inventory");
    }


    public static void printRoomDetail(Room room){
        System.out.println("Friendly NPC:");
//        for (int i = 0; i < room.getNpcs().l)
    }

    public static boolean quitGame(){
        System.out.println("Are you sure you want to quit? (y/n)");
        return confirmation();
    }

    public static boolean confirmation(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            String ans = scanner.nextLine();
            if (ans.equals("y")){
                return true;
            }
            else if (ans.equals("n")){
                System.out.println("You have chosen not to quit the game.");
                break;
            }else{
                System.out.println("Invalid Command: Please answer y or n");
            }
        }
        return false;
    }
}
