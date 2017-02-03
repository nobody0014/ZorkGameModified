package io.muic.ooc.Command.ActualCommand;

import io.muic.ooc.Command.Command;
import io.muic.ooc.Item.Item;
import io.muic.ooc.Quest.Quest;
import io.muic.ooc.RoomAndLevel.Level;
import io.muic.ooc.RoomAndLevel.LevelFactory;
import io.muic.ooc.RoomAndLevel.Room;
import io.muic.ooc.Unit.NPC;
import io.muic.ooc.Unit.Player;
import io.muic.ooc.Unit.QuestGiver;

import java.util.List;

/**
 * Created by wit on 2/1/2017 AD.
 */
public class Talk extends Command{

    @Override
    public boolean execute(){
        List<String> arguments = getArguments();
        Level currentLevel = getCurrentLevel();
        Room currentRoom = currentLevel.getCurrentRoom();
        Player player = getPlayer();

        if (arguments.size() > 0){
            if (currentRoom.getNpcs().contains(arguments.get(0))){
                NPC npc = currentRoom.getNpcs().get(currentRoom.getNpcs().indexOf(arguments.get(0)));
                if (npc instanceof QuestGiver){
                    QuestGiver qg = (QuestGiver) npc;
                    interact(player,qg);
                }else {
                    //print sth but ill have to create it later
                    System.out.println("Dont talk to me im not a quest giver.");
                }
            }else {
                System.out.println("Specified npc is not in this room");
            }
        }else {
            System.out.println("No specific npc given.");
        }
        return true;
    }

    public void interact(Player player, QuestGiver questGiver){
        if(questGiver.getQuest() == null){
            System.out.println("I have no more quest for you ");
        } else if (player.getCurrentQuests().contains(questGiver.getQuest())){
            Quest currentQuest  = questGiver.getQuest();
            if (currentQuest.isCompleteStatus() && !currentQuest.isRewardObtained()){
                player.gainExp(currentQuest.getQuestRewardExp());
                for (Item rewardItem: currentQuest.getQuestRewardItem()){
                    player.addItemToInventory(rewardItem);
                }
                questGiver.questDone();
                int index = player.getCurrentQuests().indexOf(currentQuest);
                player.getCompletedQuests().add(player.getCurrentQuests().get(index));
                player.getCurrentQuests().remove(index);
                System.out.println("Quest " + currentQuest.getQuestName() + " has been completed and rewards have been obtained.");
            } else {
                System.out.println("Go to " + currentQuest.getQuestPossibleLocations() + " to do the quest");
            }
        } else{
            Quest newQuest  = questGiver.getQuest();
            player.getCurrentQuests().add(newQuest);
            for(String location: newQuest.getQuestPossibleLocations()){
                if (!LevelFactory.HUB.getCurrentRoom().getLevelExits().keySet().contains(location)) {
                    LevelFactory.HUB.getCurrentRoom().getLevelExits().put(location, LevelFactory.levelHashMap.get(location));
                }
            }
            System.out.println("Quest " + newQuest.getQuestName() + " has been obtained.");
        }
    }

    public void help(){
        System.out.println("talk -- not implemented correctly");
    }
}
