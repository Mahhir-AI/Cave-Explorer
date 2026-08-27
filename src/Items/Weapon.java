/*
damage
usesRemaining
use() - method that defines how weapon is used
*/

package src.Items;

public class Weapon extends Item {
    public int damage;

    public Weapon(String name, int damage, int usesRemaining) {
        super(name, true, usesRemaining);
        this.damage = damage;
    }
}