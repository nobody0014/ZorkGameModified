package io.muic.ooc.RoomAndLevel;

/**
 * Created by wit on 1/28/2017 AD.
 */
public class Level {
    private Room[][] rooms;

    private String roomsName;

    private int playerX;
    private int playerY;
    private int size;

    public Level(int size, String roomName){
        this.size = size;
        rooms = new Room[size][size];
        this.roomsName = roomName;
    }

    /**
     * This method is used to check whether the pattern of the password is correct or not
     * @param locationX location of the Room in Level x matrix,
     * @param locationY location of the Room in Level y matrix,
     * @param room the actual room
     * @return true if the room is added in successfully,
     *         false otherwise (could be because of room already added at that slot or bad location)
     *
     */
    public boolean addRoom(int locationX, int locationY, Room room ){
        if (locationX < rooms.length && locationY < rooms.length && rooms[locationX][locationY] == null){
            rooms[locationX][locationY] = room;
            return true;
        }
        return false;
    }

    public Room getCurrentRoom(){
        return rooms[getPlayerX()][getPlayerY()];
    }
    public Room getSpecifiedRoom(int x, int y){
        return rooms[x][y];
    }

    public void fillAllRooms(){
        for (int i = 0; i < rooms.length;i++){
            for (int j = 0; j < rooms.length; j++){
                rooms[i][j] = null;
            }
        }
    }

    public boolean changeRoom(String direction){
        boolean changeRoomSuccess = false;
        if (direction.equals("north") && getPlayerY()-1 >= 0 && rooms[getPlayerX()][getPlayerY()-1] != null){
            changeRoomSuccess = true;
            setPlayerY(getPlayerY()-1);
        }else if (direction.equals("south") && getPlayerY()+1 < getSize() && rooms[getPlayerX()][getPlayerY()+1] != null) {
            changeRoomSuccess = true;
            setPlayerY(getPlayerY()+1);
        }else if (direction.equals("east") && getPlayerX()+1 < getSize()  && rooms[getPlayerX()+1][getPlayerY()] != null){
            changeRoomSuccess = true;
            setPlayerX(getPlayerX()+1);
        }else if (direction.equals("west") && getPlayerX()-1 >= 0 && rooms[getPlayerX()-1][getPlayerY()] != null){
            changeRoomSuccess = true;
            setPlayerX(getPlayerX()-1);
        }
        return changeRoomSuccess;
    }

    public Level changeLevel(String desiredDestination){
        return rooms[getPlayerX()][getPlayerY()].getLevelExit(desiredDestination);
    }

    public int getPlayerX() {
        return playerX;
    }

    public void setPlayerX(int playerX) {
        this.playerX = playerX;
    }

    public int getPlayerY() {
        return playerY;
    }

    public void setPlayerY(int playerY) {
        this.playerY = playerY;
    }

    public String getRoomsName() {
        return roomsName;
    }

    public int getSize() {
        return size;
    }
}
