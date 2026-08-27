/*
one class, initiate new DamagePotion() with level
eg.
    new DamagePotion("Lv1", 10 damage);
    new DamagePotion("Lv2", 40 damage);
*/

package src.Items;

public class DamagePotion extends Weapon {
    public DamagePotion(String level, int damage, int uses) {
        super("Damage Potion " + level, damage, uses);
        // differentiated in ItemFactory.java
    }
}