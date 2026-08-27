package src.Rooms;

import src.Chest;

public class SmallRoom extends Room {
    public SmallRoom() {
        super("Small Room");
        new Chest("basic", 0.1);
    }
}