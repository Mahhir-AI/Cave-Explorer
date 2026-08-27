package src.Rooms;

import src.Chest;
import src.Enemies.Enemy;

public class RoomBuilder {
    private String name;
    private Chest chest;
    private Enemy enemy;

    public RoomBuilder(String name) {
        this.name = name;
    }

    public RoomBuilder setChest(Chest chest) {
        this.chest = chest;
        return this;
    }

    public RoomBuilder setEnemy(Enemy enemy) {
        this.enemy = enemy;
        return this;
    }

    public Room build() {
        Room room;
        switch (name) {
            case "StarterRoom":
                room = new StarterRoom();
                break;
            case "SmallRoom":
                room = new SmallRoom();
                break;
            case "MidRoom":
                room = new MidRoom();
                break;
            case "BigRoom":
                room = new BigRoom();
                break;
            default:
                throw new IllegalArgumentException("Unknown room type: " + name);
        }

        if (enemy != null) {
            room.setEnemy(enemy);
        }

        if (chest != null) {
            room.setChest(chest);
        }
        return room;
    }
}