package io.muic.ooc.RoomAndLevel;

/**
 * Created by wit on 1/28/2017 AD.
 */
public class Level {
    private Room[][] rooms;

    private int level;

    private int playerX;
    private int playerY;
    private int size;

    private String levelName;

    public Level(int size, String levelName, int level){
        this.size = size;
        rooms = new Room[size][size];
        this.level = level;
        this.levelName = levelName;
    }


    public void fillAllRooms(){
        for (int i = 0; i < rooms.length;i++){
            for (int j = 0; j < rooms.length; j++){
                rooms[i][j] = null;
            }
        }
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

    public void changeRoom(String direction){
        if (direction.equals("north") ){ //&& getPlayerY()-1 >= 0 && rooms[getPlayerX()][getPlayerY()-1] != null
            setPlayerY(getPlayerY()-1);
        }else if (direction.equals("south")) { //&& getPlayerY()+1 < getSize() && rooms[getPlayerX()][getPlayerY()+1] != null
            setPlayerY(getPlayerY()+1);
        }else if (direction.equals("east")){ //&& getPlayerX()+1 < getSize()  && rooms[getPlayerX()+1][getPlayerY()] != null
            setPlayerX(getPlayerX()+1);
        }else if (direction.equals("west") ){ //&& getPlayerX()-1 >= 0 && rooms[getPlayerX()-1][getPlayerY()] != null
            setPlayerX(getPlayerX()-1);
        }
        getCurrentRoom().enter();
    }

    public Level changeLevel(String desiredDestination){
        return getCurrentRoom().getLevelExit(desiredDestination);
    }

    public Room getCurrentRoom(){
        return rooms[getPlayerX()][getPlayerY()];
    }

    public Room getSpecifiedRoom(int x, int y){
        return rooms[x][y];
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

    public int getSize() {
        return size;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public Room[][] getRooms() {
        return rooms;
    }
}
