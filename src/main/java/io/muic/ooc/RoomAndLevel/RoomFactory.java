package io.muic.ooc.RoomAndLevel;

import io.muic.ooc.Item.*;
import io.muic.ooc.Unit.Monster;
import io.muic.ooc.Unit.MonsterFactory;
import io.muic.ooc.Unit.QuestGiver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by wit on 1/30/2017 AD.
 */
public class RoomFactory {
    public static Room createHubRoom(){
        Room room = new Room(0,0);
        room.addLevelExit("forest", LevelFactory.createFirstLevelFirstDungeon());
        return room;
    }

    public static Room createForestRoom(int x, int y){
        Room room = new Room(x,y);
        Random rand  = new Random();
        List<Monster> monsters = MonsterFactory.createMonsters(rand.nextInt(3));
        for (Monster mon: monsters){
            room.addNPC(mon);
        }
        List<Equipment> equipments = EquipmentFactory.createEquipments(2);
        for (Equipment equipment: equipments){
            room.addItem(equipment);
        }
        List<Consumable> consumables = ConsumableFactory.createConsumables(2);
        for (Consumable consumable: consumables){
            room.addItem(consumable);
        }
        return room;
    }
}
