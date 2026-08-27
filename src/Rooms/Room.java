package src.Rooms;

import src.Chest;
import src.Enemies.Enemy;
import src.Items.Page;
import java.util.ArrayList;
import java.util.List;

public class Room {
    public String name;
    public boolean isOpened = false;
    public Chest chest = null;
    public Enemy enemy = null;
    public Page page = null;

    public List<Room> connectedRooms = new ArrayList<>();

    public void addConnection(Room room) {
        this.connectedRooms.add(room);
    }

    public Room(String name) {
        this.name = name;
    }

    public void setChest(Chest c) {
        this.chest = c;
    }

    public void setEnemy(Enemy e) {
        this.enemy = e;
    }

    public void setPage(Page p) {
        this.page = p;
    }

}

/*
 * for loop:
 * - label for every chest in every room (S1-S10, M1-M6, B1-B4)
 * - in each group, pick 2/3/4 rooms to have a chest
 * - how to code the logic for "does this chest have a room"? i'm thinking loop
 * through an array containing all labels...
 * 
 */