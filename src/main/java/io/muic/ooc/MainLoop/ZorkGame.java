package io.muic.ooc.MainLoop;

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
        System.out.println("------------------------");

        ZorkRunner zorkRunner = new ZorkRunner(name);

        while (true){
            String nextLine = cin.nextLine();
            if (!zorkRunner.executeCommand(nextLine.split(" "))){
                break;
            }
        }
        System.out.println("Thank you for playing");
    }
}
