package src.Rooms;

import src.Chest;

public class BigRoom extends Room {
    public BigRoom() {
        super("Big Room");
        new Chest("superior", 0.4);
    }
}