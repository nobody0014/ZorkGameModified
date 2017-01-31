package io.muic.ooc.RoomAndLevel;

/**
 * Created by wit on 1/30/2017 AD.
 */
public class RoomsFactory {
    public static Rooms createHubLevel(){
        Rooms hubLevel = new Rooms(1,"hub");
        hubLevel.addRoom(0,0,RoomFactory.createHubRoom());
        hubLevel.setPlayerX(0);
        hubLevel.setPlayerY(0);
        return hubLevel;
    }

    public static Rooms createFirstLevelFirstDungeon(){
        Rooms firstLevel = new Rooms(4,"first");
        firstLevel.fillAllRooms();
        firstLevel.addRoom(0,0, new Room());
        firstLevel.addRoom(1,0, new Room());
        firstLevel.addRoom(2,0, new Room());
        firstLevel.addRoom(3,0, new Room());
        firstLevel.addRoom(0,1, new Room());
        firstLevel.addRoom(0,2, new Room());
        firstLevel.addRoom(0,3, new Room());
        firstLevel.addRoom(1,1, new Room());
        firstLevel.addRoom(1,2, new Room());
        firstLevel.addRoom(2,2, new Room());
        firstLevel.addRoom(3,1, new Room());
        firstLevel.addRoom(3,2, new Room());
        firstLevel.addRoom(3,3, new Room());

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
