package src;

import src.Rooms.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import src.Enemies.Enemy;
import src.Enemies.EnemyFactory;
import src.Items.Page;

public class Game {
    private static Game instance = null;
    private Random rng;
    private List<Room> worldRooms = new ArrayList<>();

    private Game() {
        this.rng = new Random();
        generateWorld();
    }

    public static synchronized Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public Random getRng() {
        return this.rng;
    }

    public List<Room> getWorldRooms() {
        return this.worldRooms;
    }

    public void generateWorld() {
        worldRooms.clear();

        // starter room
        StarterRoom starter = new StarterRoom();
        worldRooms.add(starter);

        // small rooms (basic chests)
        int smallRoomCount = 10;
        ArrayList<Boolean> smallChestSlots  = new ArrayList<>(Arrays.asList(true, true, false, false, false, false, false, false, false, false));
        Collections.shuffle(smallChestSlots, rng);
        for (int i = 0; i < smallRoomCount; i++) {
            SmallRoom r = new SmallRoom();
            if (smallChestSlots.get(i)) {
                Chest c = new Chest("basic", 0.4);
                c.fill(rng);
                r.setChest(c);
            }
            worldRooms.add(r);
        }

        // mid rooms (major chests)
        int midRoomCount = 6;
        List<Boolean> pageSlots = new ArrayList<>(Arrays.asList(true, true, true, false, false, false));
        // 3 out of 6 rooms get a page
        Collections.shuffle(pageSlots, rng); // reorder list to determine which rooms get pages
        String[] midRoomEnemies = { "Goblin", "MegaRat", "GiantSpider" };
        ArrayList<Boolean> midChestSlots  = new ArrayList<>(Arrays.asList(true, true, true, false, false, false));
        Collections.shuffle(midChestSlots, rng);
        for (int i = 0; i < midRoomCount; i++) {
            MidRoom r = new MidRoom();
            if (midChestSlots.get(i)) {
                Chest c = new Chest("major", 0.6);
                c.fill(rng);
                r.setChest(c);
            }
            if (pageSlots.get(i)) {
                r.setPage(new Page()); // return i'th room and checks if it relates to true (page) or false (no page)
            }
            if (rng.nextDouble() < 0.5) {
                int enemyIndex = rng.nextInt(midRoomEnemies.length);
                Enemy e = EnemyFactory.createEnemy(midRoomEnemies[enemyIndex]);
                r.setEnemy(e);
            }
            worldRooms.add(r);
        }

        // big rooms (superior chests)
        int bigRoomCount = 4;
        // double superiorChestChance = 1; not really needed
        for (int i = 0; i < bigRoomCount; i++) {
            BigRoom r = new BigRoom();
            Chest c = new Chest("superior", 0.8);
            c.fill(rng);
            r.setChest(c);
            if (i == 2)
                r.setEnemy(EnemyFactory.createEnemy("Dragon"));
            if (i == 3)
                r.setEnemy(EnemyFactory.createEnemy("Troll"));
            r.setPage(new Page());
            worldRooms.add(r);
        }

        for (int i = 0; i < worldRooms.size() - 1; i++) { // loops through all rooms except the last one
            Room current = worldRooms.get(i);
            Room next = worldRooms.get(i + 1);
            current.addConnection(next); // reach next room from current room
            next.addConnection(current); // reach current room from next room
        }
    }
}

/*
 * public static final String[] BAD_ITEMS = {
 * "Worn out rope", "Torn cloth", "Seeds", "Blunt knife",
 * "Rotten apple core", "Broken compass", "Map of different cave",
 * "Stone key", "Old coins", "Finished torch", "Electrical wire"
 * };
 * 
 * when chest needs random bad item
 * String randomBadItem = Game.BAD_ITEMS[rng.nextInt(Game.BAD_ITEMS.length)];
 * ItemFactory.createItem(randomBadItem);
 */
