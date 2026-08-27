package src.Rooms;

public class RoomFactory {
    public static Room createRoom(String type) {
        switch (type) {
            case "Starter": return new StarterRoom();
            case "Small": return new SmallRoom();
            case "Mid": return new MidRoom();
            case "Big": return new BigRoom();
            default: throw new IllegalArgumentException("Unknown room type: " + type);
        }
    }
}