package io.muic.ooc.RoomAndLevel;

/**
 * Created by wit on 1/30/2017 AD.
 */
public class LevelFactory {
    public static Level createHubLevel(){
        Level hubLevel = new Level(1,"hub",0);
        hubLevel.addRoom(0,0,RoomFactory.createHubRoom());
        hubLevel.setPlayerX(0);
        hubLevel.setPlayerY(0);
        return hubLevel;
    }

    public static Level createFirstLevelFirstDungeon(){
        Level firstLevel = new Level(1,"forest",0);
        firstLevel.fillAllRooms();
        firstLevel.addRoom(0,0, new Room(0,0));
        firstLevel.addRoom(1,0, new Room(1,0));
        firstLevel.addRoom(2,0, new Room(2,0));
        firstLevel.addRoom(3,0, new Room(3,0));
        firstLevel.addRoom(0,1, new Room(0,1));
        firstLevel.addRoom(0,2, new Room(0,2));
        firstLevel.addRoom(0,3, new Room(0,3));
        firstLevel.addRoom(1,1, new Room(1,1));
        firstLevel.addRoom(1,2, new Room(1,2));
        firstLevel.addRoom(2,2, new Room(2,2));
        firstLevel.addRoom(3,1, new Room(3,1));
        firstLevel.addRoom(3,2, new Room(3,2));
        firstLevel.addRoom(3,3, new Room(3,3));

        //first room 0,0
        firstLevel.getSpecifiedRoom(0,0).addExit("east",firstLevel.getSpecifiedRoom(1,0));
        firstLevel.getSpecifiedRoom(0,0).addExit("south",firstLevel.getSpecifiedRoom(0,1));

        //second room 0,1
        firstLevel.getSpecifiedRoom(0,1).addExit("south",firstLevel.getSpecifiedRoom(0,0));
        firstLevel.getSpecifiedRoom(0,1).addExit("south",firstLevel.getSpecifiedRoom(1,0));

        //0,2
        firstLevel.getSpecifiedRoom(0,2).addExit("east",firstLevel.getSpecifiedRoom(1,2));
        firstLevel.getSpecifiedRoom(0,2).addExit("east",firstLevel.getSpecifiedRoom(0,3));
        firstLevel.getSpecifiedRoom(0,2).addExit("east",firstLevel.getSpecifiedRoom(1,2));

        //0,3
        firstLevel.getSpecifiedRoom(0,3).addExit("east",firstLevel.getSpecifiedRoom(0,2));

        //1,0
        firstLevel.getSpecifiedRoom(1,0).addExit("east",firstLevel.getSpecifiedRoom(0,0));
        firstLevel.getSpecifiedRoom(1,0).addExit("east",firstLevel.getSpecifiedRoom(2,0));

        //2,0
        firstLevel.getSpecifiedRoom(2,0).addExit("east",firstLevel.getSpecifiedRoom(1,0));
        firstLevel.getSpecifiedRoom(2,0).addExit("east",firstLevel.getSpecifiedRoom(3,0));

        //3,0
        firstLevel.getSpecifiedRoom(3,0).addExit("east",firstLevel.getSpecifiedRoom(2,0));
        firstLevel.getSpecifiedRoom(3,0).addExit("east",firstLevel.getSpecifiedRoom(3,1));

        //3,1
        firstLevel.getSpecifiedRoom(3,1).addExit("east",firstLevel.getSpecifiedRoom(3,0));
        firstLevel.getSpecifiedRoom(3,1).addExit("east",firstLevel.getSpecifiedRoom(3,2));

        //3,2
        firstLevel.getSpecifiedRoom(3,2).addExit("east",firstLevel.getSpecifiedRoom(3,3));
        firstLevel.getSpecifiedRoom(3,2).addExit("east",firstLevel.getSpecifiedRoom(2,2));

        //3,3
        firstLevel.getSpecifiedRoom(3,3).addExit("east",firstLevel.getSpecifiedRoom(3,2));

        //1,2
        firstLevel.getSpecifiedRoom(1,2).addExit("east",firstLevel.getSpecifiedRoom(0,2));
        firstLevel.getSpecifiedRoom(1,2).addExit("east",firstLevel.getSpecifiedRoom(2,2));

        //2,2
        firstLevel.getSpecifiedRoom(2,2).addExit("east",firstLevel.getSpecifiedRoom(3,2));
        firstLevel.getSpecifiedRoom(2,2).addExit("east",firstLevel.getSpecifiedRoom(1,2));



        return firstLevel;
    }
}
