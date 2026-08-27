package src.Enemies;

public class EnemyFactory {
    public static Enemy createEnemy(String type) {
        switch (type) {
            case "Goblin": return new Goblin();
            case "MegaRat": return new MegaRat();
            case "GiantSpider": return new GiantSpider();
            case "Dragon": return new Dragon();
            case "Troll": return new Troll();
            default: throw new IllegalArgumentException("Unknown enemy type: " + type);
        }
    }
}