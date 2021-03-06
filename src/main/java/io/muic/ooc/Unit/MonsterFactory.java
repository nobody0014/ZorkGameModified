package io.muic.ooc.Unit;

import java.util.*;

/**
 * Created by wit on 1/12/2017 AD.
 */
public class MonsterFactory {

    public static List<String> forestMonsters = Arrays.asList("goblin","elf","wolf","orc");

    public static List<String> allMonsters = Arrays.asList("goblin","elf","wolf","orc");

    public static Monster createGoblin(){
        Monster monster = new Monster("goblin",2,2,2,2,2,2,1,3);
        monster.setAggro(true);
        return monster;
    }

    public static Monster createWolf(){
        Monster monster = new Monster("wolf",2,0,2,2,4,2,1,4);
        monster.setAggro(true);
        monster.updateStatus();
        return monster;
    }
    public static Monster createOrc(){
        Monster monster = new Monster("orc",4,4,0,0,2,3,2,7);
        monster.setAggro(true);
        monster.updateStatus();
        return monster;
    }
    public static Monster createElf(){
        Monster monster = new Monster("elf",2,2,2,2,4,4,1,4);
        monster.setAggro(true);
        monster.updateStatus();
        return monster;
    }

    public static ArrayList<Monster> createMonsters(int limit){
        ArrayList<Monster> monsters = new ArrayList<>();
        Random rand = new Random();
        if (limit > 0){
            int no = rand.nextInt(limit);
            for (int i = 0; i < no; i++){
                String monsterRandomed = forestMonsters.get(rand.nextInt(forestMonsters.size()));
                if (monsterRandomed.equals("goblin")){
                    monsters.add(createGoblin());
                }else if (monsterRandomed.equals("wolf")){
                    monsters.add(createWolf());
                }else if (monsterRandomed.equals("orc")){
                    monsters.add(createOrc());
                } else if (monsterRandomed.equals("elf")) {
                    monsters.add(createElf());
                }
            }
        }
        return monsters;
    }
}
