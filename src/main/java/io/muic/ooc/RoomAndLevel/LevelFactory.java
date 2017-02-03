package io.muic.ooc.RoomAndLevel;

import java.util.HashMap;

/**
 * Created by wit on 1/30/2017 AD.
 */
public class LevelFactory {
    public static final Level HUB = createHub();

    public static Level createHub(){
        Level hub = new Level(1,"hub",0);
        hub.addRoom(0,0,RoomFactory.createHubRoom());
        hub.setPlayerX(0);
        hub.setPlayerY(0);
        return hub;
    }

    public static HashMap<String, Level> levelHashMap = new HashMap<String, Level>(){
        {
            put("hub", HUB);
            put("forest", createFirstLevelFirstDungeon());
        }
    };

    public static Level createFirstLevelFirstDungeon(){
        Level firstLevel = new Level(4,"forest",0);
        firstLevel.fillAllRooms();
        firstLevel.addRoom(0,0, RoomFactory.createForestRoom(0,0));
        firstLevel.addRoom(0,1, RoomFactory.createForestRoom(0,1));
        firstLevel.addRoom(0,2, RoomFactory.createForestRoom(0,2));
        firstLevel.addRoom(0,3, RoomFactory.createForestRoom(0,3));

        firstLevel.addRoom(1,0, RoomFactory.createForestRoom(1,0));
        firstLevel.addRoom(1,1, RoomFactory.createForestRoom(1,1));
        firstLevel.addRoom(1,2, RoomFactory.createForestRoom(1,2));

        firstLevel.addRoom(2,0, RoomFactory.createForestRoom(2,0));
        firstLevel.addRoom(2,2, RoomFactory.createForestRoom(2,2));

        firstLevel.addRoom(3,0, RoomFactory.createForestRoom(3,0));
        firstLevel.addRoom(3,1, RoomFactory.createForestRoom(3,1));
        firstLevel.addRoom(3,2, RoomFactory.createForestRoom(3,2));
        firstLevel.addRoom(3,3, RoomFactory.createForestRoom(3,3));

        //first room 0,0
        firstLevel.getSpecifiedRoom(0,0).addExit("east",firstLevel.getSpecifiedRoom(1,0));
        firstLevel.getSpecifiedRoom(0,0).addExit("south",firstLevel.getSpecifiedRoom(0,1));
        firstLevel.getSpecifiedRoom(0,0).addLevelExit("hub", LevelFactory.HUB);

        //second room 0,1
        firstLevel.getSpecifiedRoom(0,1).addExit("north",firstLevel.getSpecifiedRoom(0,0));
        firstLevel.getSpecifiedRoom(0,1).addExit("south",firstLevel.getSpecifiedRoom(1,0));

        //0,2
        firstLevel.getSpecifiedRoom(0,2).addExit("east",firstLevel.getSpecifiedRoom(1,2));
        firstLevel.getSpecifiedRoom(0,2).addExit("south",firstLevel.getSpecifiedRoom(0,3));

        //0,3
        firstLevel.getSpecifiedRoom(0,3).addExit("north",firstLevel.getSpecifiedRoom(0,2));

        //1,0
        firstLevel.getSpecifiedRoom(1,0).addExit("west",firstLevel.getSpecifiedRoom(0,0));
        firstLevel.getSpecifiedRoom(1,0).addExit("east",firstLevel.getSpecifiedRoom(2,0));

        //2,0
        firstLevel.getSpecifiedRoom(2,0).addExit("west",firstLevel.getSpecifiedRoom(1,0));
        firstLevel.getSpecifiedRoom(2,0).addExit("east",firstLevel.getSpecifiedRoom(3,0));

        //3,0
        firstLevel.getSpecifiedRoom(3,0).addExit("west",firstLevel.getSpecifiedRoom(2,0));
        firstLevel.getSpecifiedRoom(3,0).addExit("south",firstLevel.getSpecifiedRoom(3,1));

        //3,1
        firstLevel.getSpecifiedRoom(3,1).addExit("north",firstLevel.getSpecifiedRoom(3,0));
        firstLevel.getSpecifiedRoom(3,1).addExit("south",firstLevel.getSpecifiedRoom(3,2));

        //3,2
        firstLevel.getSpecifiedRoom(3,2).addExit("south",firstLevel.getSpecifiedRoom(3,3));
        firstLevel.getSpecifiedRoom(3,2).addExit("west",firstLevel.getSpecifiedRoom(2,2));

        //3,3
        firstLevel.getSpecifiedRoom(3,3).addExit("north",firstLevel.getSpecifiedRoom(3,2));
        firstLevel.getSpecifiedRoom(3,3).addLevelExit("hub", LevelFactory.HUB);

        //1,2
        firstLevel.getSpecifiedRoom(1,2).addExit("west",firstLevel.getSpecifiedRoom(0,2));
        firstLevel.getSpecifiedRoom(1,2).addExit("east",firstLevel.getSpecifiedRoom(2,2));

        //2,2
        firstLevel.getSpecifiedRoom(2,2).addExit("east",firstLevel.getSpecifiedRoom(3,2));
        firstLevel.getSpecifiedRoom(2,2).addExit("west",firstLevel.getSpecifiedRoom(1,2));




        return firstLevel;
    }
}
