package src.Items;

import src.Player;
import src.Enemies.Enemy;

public class Shield extends Item {
    public Shield() {
        super("Shield", true, 5);
    }

    public void use(Player player, Enemy enemy) {
        System.out.println("Shield equipped! Incoming damage will be reduced for the next 5 hits.");
    }

}