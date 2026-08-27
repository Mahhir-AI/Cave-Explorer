package src.Items;

import src.Player;
import src.Enemies.Enemy;

public class Food extends Item {
    public Food() {
        super("Food", true, 2);
    }

    public void use(Player player, Enemy enemy) {
        player.health += 10;
        if (player.health > 100) {
            player.health = 100;
        }
        super.use(player, enemy);
    }
}