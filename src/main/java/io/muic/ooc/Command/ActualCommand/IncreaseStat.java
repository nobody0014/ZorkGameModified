package io.muic.ooc.Command.ActualCommand;

import io.muic.ooc.Command.Command;
import io.muic.ooc.Unit.Player;

import java.util.List;

/**
 * Created by wit on 2/3/2017 AD.
 */
public class IncreaseStat extends Command {
    @Override
    public boolean execute(){
        Player player = getPlayer();
        if (player.getStatPoints() <= 0){
            System.out.println("not enough stat point to level up the specified stat");
            return true;
        }

        List<String> arguments = getArguments();

        if (arguments.size() > 0){
            String stat= arguments.get(0);
            if (stat.equals("strength") || stat.equals(stat)){
                player.increaseStr();
            }else if (stat.equals("constitution") || stat.equals("con")){
                player.increaseCon();
            }else if (stat.equals("intelligence") || stat.equals("int")){
                player.increaseInt();
            }else if (stat.equals("wisdom") || stat.equals("wis")){
                player.increaseWis();
            }else if (stat.equals("dexterity") || stat.equals("dex")){
                player.increaseDex();
            }else if (stat.equals("luck")){
                player.increaseLuck();
            }
            player.updateStatus();
            System.out.println("Increase stat has been successful, status is updated");
        }else {
            System.out.println("No argument was given");
        }
        return true;
    }

    public void help(){
        System.out.println("increasestat <stat name> -- lose 1 stat point for increasing 1 base stat of your choice");
    }
}
