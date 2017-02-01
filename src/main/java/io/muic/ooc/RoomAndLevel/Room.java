package io.muic.ooc.RoomAndLevel;

import io.muic.ooc.Item.Item;
import io.muic.ooc.Unit.NPC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by wit on 1/28/2017 AD.
 */
public class Room {
    private int roomX;
    private int roomY;
    private List<NPC> npcs = new ArrayList<>();
    private List<Item> items = new ArrayList<>();
    private HashMap<String, Room> exits = new HashMap<>();
    private HashMap<String, Level> levelExits = new HashMap<>();

    private boolean isVisited = false;

    public Room(int x, int y){
        setRoomX(x);
        setRoomY(y);
    }

    public void enter(){
        setVisited(true);
    }

    public void addNPC(NPC npc){
        getNpcs().add(npc);
    }

    public void addItem(Item item){
        getItems().add(item);
    }

    public void addExit(String direction, Room room){
        getExits().putIfAbsent(direction,room);
    }

    public void addLevelExit(String desiredDestination, Level level){
        getLevelExits().putIfAbsent(desiredDestination,level);
    }

    public Level getLevelExit(String desiredDestination){
        return getLevelExits().getOrDefault(desiredDestination,null);
    }

    public Room getExit(String direction){
        return getExits().getOrDefault(direction,null);
    }

    public List<NPC> getNpcs() {
        return npcs;
    }

    public List<Item> getItems() {
        return items;
    }


    public HashMap<String, Room> getExits() {
        return exits;
    }

    public HashMap<String, Level> getLevelExits() {
        return levelExits;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public int getRoomX() {
        return roomX;
    }

    public void setRoomX(int roomX) {
        this.roomX = roomX;
    }

    public int getRoomY() {
        return roomY;
    }

    public void setRoomY(int roomY) {
        this.roomY = roomY;
    }
}
