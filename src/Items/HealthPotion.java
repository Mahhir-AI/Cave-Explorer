package src.Items;

import src.Player;
import src.Enemies.Enemy;

public class HealthPotion extends Item {
    public HealthPotion() {
        super("Health Potion", true, 1);
    }

    public void use(Player player, Enemy enemy) {
        player.health += 50;
        if (player.health > 100) {
            player.health = 100;
        }
        super.use(player, enemy);
    }
}