package src.Enemies;

import java.util.Random;

public class Dragon extends Enemy {
    private Random random = new Random();

    public Dragon() {
        super("Dragon", 20);
    }

    @Override
    public int attack() {
        super.attack();
        if (random.nextInt(100) < 10) { // 10% chance
            damage *= 2;
            System.out.println("In a fit of rage, the dragon deals DOUBLE damage!");
            return damage;
        }
        return damage;
    }
}