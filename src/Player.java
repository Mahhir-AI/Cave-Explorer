package src;

import java.util.List;
import java.util.Scanner;

import src.Enemies.Enemy;
import src.Items.Item;
import src.Items.Weapon;
import src.Rooms.Room;

public class Player {
    public int health = 100;
    Inventory inventory = new Inventory();
    public int attacksDealt = 0; // for final score, increments universally for all enemies
    public int attacksReceived = 0; // for final score, increments universally for all enemies
    public Room currentRoom = null;
    public int roomIndex = 0;

    public Player() {
    }

    public void moveForward(List<Room> listOfRooms) {
        if (roomIndex + 1 < listOfRooms.size()) { // ensure i'm not in last room
            roomIndex++;
            currentRoom = listOfRooms.get(roomIndex); // match current room to index
        } else {
            System.out.println("You cannot move forward, there is no room ahead.");
        }
    }

    public void moveBack(List<Room> listOfRooms) {
        if (roomIndex - 1 >= 0) { // ensure i'm not in first room
            roomIndex--;
            currentRoom = listOfRooms.get(roomIndex); // match current room to index
        } else {
            System.out.println("You cannot move back, there is no room behind.");
        }
    }

    public void attack(Enemy enemy, Weapon weapon) {
        if (weapon != null) {
            enemy.health = enemy.health - weapon.damage;
            attacksDealt++;
            System.out.println("\nYou attacked " + enemy.name + " with your " + weapon.name + ", dealing "
                    + weapon.damage + " damage!");
            if (inventory.getWeaponCount() >= 2) {
                weapon.usesRemaining--;
                if (weapon.usesRemaining <= 0) {
                    inventory.removeItem(weapon);
                    System.out.println("Your " + weapon.name + " broke!");
                }
            }
        } else {
            System.out.println("You have no weapon to attack with!");
        }
    }

    public void receiveAttack(Enemy enemy) {
        int dmg = enemy.attack();
        Item shield = inventory.getShield();
        if (shield != null) {
            System.out.println("Your shield has " + shield.usesRemaining + " uses remaining.");
            dmg = dmg - (int) (dmg * 0.2);
            shield.usesRemaining--;
            if (shield.usesRemaining <= 0) {
                inventory.removeItem(shield);
                System.out.println("After taking 5 hits, your shield has finally broken!");
            } else {
                System.out.println(
                        "You used a shield to reduce incoming damage by 20% for the next " + shield.usesRemaining
                                + " attacks!");
            }
        }
        health = health - dmg;
        attacksReceived++;
        System.out.println("You received " + dmg + " damage from " + enemy.name + "!");
    }

    public void calculateScore() {
        int score = 0;
        score += health * 10;
        score += attacksDealt * 5;
        score -= attacksReceived;
        if (score < 0) {
            score = 0;
        }
        System.out.println("Your final score is: " + score);
    }

    public boolean use(Scanner scanner, Enemy enemy) {
        System.out.println("Your inventory:");
        inventory.display();
        if (inventory.playersItems.isEmpty()) {
            System.out.println("You have no items to use.");
            return false;
        }
        System.out.println("\nType the name of the item you want to use: ");
        String itemName = scanner.nextLine();
        Item found = null;
        for (Item itemInInv : inventory.playersItems) {
            if (itemName.equalsIgnoreCase(itemInInv.name)) {
                found = itemInInv;
                break;
            }
        }

        if (found == null) {
            System.out.println("Item not found in inventory.");
            return false;
        }
        if (!found.usable) {
            System.out.println(found.name + " can't be used.");
            return false;
        }

        if (found instanceof Weapon && enemy != null) {
            attack(enemy, (Weapon) found);
            return true;
        } else {
            found.use(this, enemy);
            if (found.usesRemaining <= 0) {
                inventory.removeItem(found);
                System.out.println(found.name +
                        " has been used up and removed from your inventory.");
            }

        }
        return false;
    }
}