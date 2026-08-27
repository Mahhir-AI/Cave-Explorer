package src.Rooms;

import src.Chest;

public class MidRoom extends Room {
    public MidRoom() {
        super("Mid Room");
        new Chest("major", 0.2);
    }
}