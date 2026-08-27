package src.Enemies;

public class Enemy {
    public String name;
    public int health = 100;
    public int damage = 0;
    public int attacksDealt = 0; // for final score
    public int attacksReceived = 0; // for final score
    public int damageFromEnemy; // needed?

    public Enemy(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public int attack() {
        attacksDealt++;
        return damage;
    }
}