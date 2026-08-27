/*
boolean usable = true (default)
bad items: usable = false
so no need to make each bad item a new class
*/

package src.Items;

import src.Player;
import src.Enemies.Enemy;

public class Item {
    public String name;
    public boolean usable;
    public int usesRemaining;

    public Item(String name, boolean usable, int usesRemaining) {
        this.name = name;
        this.usable = usable;
        this.usesRemaining = usesRemaining;
    }

    public void use(Player player, Enemy enemy) {
        if (!usable) {
            System.out.println(name + " can't be used.");
        } else {
            usesRemaining--;
        }
    }
}