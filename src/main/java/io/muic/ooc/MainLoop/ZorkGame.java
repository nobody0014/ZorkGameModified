package io.muic.ooc.MainLoop;

import io.muic.ooc.CommandParser;

import java.util.Scanner;

/**
 * Created by wit on 1/12/2017 AD.
 */
public class ZorkGame {
    public void main(String[] args){

        Scanner cin = new Scanner(System.in);
        ZorkRunner zorkRunner = new ZorkRunner();
        while (true){
            String nextLine = cin.nextLine();
            if (zorkRunner.executeCommand(nextLine.split(" "))){
                break;
            }
        }
        System.out.println("Thank you for playing");
    }
}
