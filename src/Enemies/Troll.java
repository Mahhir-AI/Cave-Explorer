package src.Enemies;

public class Troll extends Enemy {
    private boolean tripleUsed = false;

    public Troll() {
        super("Troll", 20);
    }

    @Override
    public int attack() {
        super.attack();
        if (health <= 20 && !tripleUsed) {
            damage *= 3;
            tripleUsed = true;
            System.out.println("The troll is nearing death. It deals TRIPLE damage!");
            return damage;
        }
        return damage;
    }
}