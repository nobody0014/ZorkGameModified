package io.muic.ooc.MainLoop;

import io.muic.ooc.Command.Command;
import io.muic.ooc.Command.CommandParser;

import java.util.Scanner;

/**
 * Created by wit on 1/12/2017 AD.
 */
public class ZorkGame {
    public static void main(String[] args){

        Scanner cin = new Scanner(System.in);

        System.out.println("Welcome to Zork the Game");

        System.out.println("Please enter your name: ");
        String name = cin.nextLine();
        ZorkView.printFinishLine();

        ZorkRunner zorkRunner = new ZorkRunner(name);

        while (true){
            String command = cin.nextLine();
            Command cmd  = CommandParser.parseInput(command);
            if (!zorkRunner.executeCommand(cmd)){
                break;
            }
        }
        System.out.println("Thank you for playing");
    }
}
