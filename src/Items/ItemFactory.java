package src.Items;

public class ItemFactory {
    public static Item createItem(String type) {
        switch (type) {
            case "HealthPotion":
                return new HealthPotion();
            case "DamagePotion_Lv1":
                return new DamagePotion("Lv1", 10, 4);
            case "DamagePotion_Lv2":
                return new DamagePotion("Lv2", 40, 1);
            case "Food":
                return new Food();
            case "Shield":
                return new Shield();
            case "Sword":
                return new Sword();
            case "BowAndArrow":
                return new BowAndArrow();
            case "Slingshot":
                return new Slingshot();
            case "Whip":
                return new Whip();
            // bad items
            default:
                return new Item(type, false, 0);
        }
    }

    public static Item randomGoodWeapon() {
        String[] goodWeapons = { "Sword", "BowAndArrow", "Slingshot", "DamagePotion_Lv1", "DamagePotion_Lv2" };
        int randomIndex = (int) (Math.random() * goodWeapons.length);
        String randomWeapon = goodWeapons[randomIndex];
        return createItem(randomWeapon);
    }

}