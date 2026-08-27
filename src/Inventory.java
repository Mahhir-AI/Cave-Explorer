package src;

import java.util.ArrayList;
import java.util.List;

import src.Items.Item;

import src.Items.Weapon;

public class Inventory {
    public List<Item> playersItems = new ArrayList<>();

    public void addItem(Item item) {
        playersItems.add(item);
    }

    public void removeItem(Item item) {
        playersItems.remove(item);
    }

    public void display() {
        System.out.println("Your inventory: \n");
        for (Item itemInInv : playersItems) {
            System.out.println(itemInInv.name);
        }
        if (playersItems.isEmpty()) {
            System.out.println("Your inventory is empty.");
            return;
        }
    }

    public boolean containsItem(Item item) {
        return playersItems.contains(item);
    }

    public Weapon getWeapon() {
        for (Item itemInInv : playersItems) {
            if (itemInInv instanceof Weapon) {
                return (Weapon) itemInInv;
            }
        }
        return null; // no weapon found
    }

    public int getWeaponCount() {
        int count = 0;
        for (Item itemInInv : playersItems) {
            if (itemInInv instanceof Weapon) {
                count++;
            }
        }
        return count;
    }

    public Item getShield() {
        for (Item itemInInv : playersItems) {
            if (itemInInv instanceof src.Items.Shield) {
                return itemInInv;
            }
        }
        return null;
    }
}