/*
one class, instantiate new Chest() with a good-item probability.
eg.
    new Chest("basic", 0.1);
    new Chest("major", 0.2);
    new Chest("superior", 0.4);

Each chest will contain exactly one Item. Call `fill(game, rnd)` to assign an item.
*/

package src;

import src.Items.Item;
import src.Items.ItemFactory;

import java.util.Random;

public class Chest {
    String type;
    double goodChance;
    Item item;

    public Chest(String type, double goodChance) {
        this.type = type;
        this.goodChance = goodChance;
        this.item = null;
    }

    public void fill(Random rnd) {
        double roll = rnd.nextDouble();
        if (roll < goodChance) { // depends on chest probability
            String[] goodItems = { "HealthPotion", "DamagePotion_Lv1", "DamagePotion_Lv2", "Food", "Shield",
                    "Slingshot", "BowAndArrow", "Sword" };
            String randomGood = goodItems[rnd.nextInt(goodItems.length)];
            this.item = ItemFactory.createItem(randomGood);
        } else {
            String[] badItems = { "Worn out rope", "Torn cloth", "Seeds", "Blunt knife", "Rotten apple core",
                    "Broken compass", "Map of different cave", "Stone key", "Old coins", "Finished torch",
                    "Electrical wire" };
            String randomBad = badItems[rnd.nextInt(badItems.length)];
            this.item = ItemFactory.createItem(randomBad);
        }
    }

    public Item takeItem() {
        Item found = this.item;
        this.item = null;
        return found;
    }

    public boolean hasItem() {
        return this.item != null;
    }
}