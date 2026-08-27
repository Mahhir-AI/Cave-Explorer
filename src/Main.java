package src;

import java.util.Scanner;

import src.Items.Item;
import src.Items.ItemFactory;

public class Main {
    public static void main(String[] args) {
        // Minimal entry point while the game loop is being implemented.
        Game game = Game.getInstance();
        Player player = new Player();
        PageCollectionTracker pageTracker = new PageCollectionTracker();
        pageTracker.addObserver(GameManager.getInstance()); // GameManager singleton, watching for page collection

        // when game starts
        player.currentRoom = game.getWorldRooms().get(0);

        System.out.println("The game uses the following inputs:");
        System.out.println("F - move forward a room");
        System.out.println("B - move back a room");
        System.out.println("I - check inventory");
        System.out.println("U - use/eat");
        System.out.println("C - open chest\n");

        Scanner myScanner = new Scanner(System.in);

        while (!GameManager.getInstance().isGameWon() && player.health > 0) {
            System.out.println("\nThe current room is: " + player.currentRoom.name);
            if (player.currentRoom.chest != null) {
                System.out.println("This room has a " + player.currentRoom.chest.type + " chest in it.");
            }
            System.out.println("You have collected " + GameManager.getInstance().getPagesCollected() + " pages.");
            System.out.println("Your health is: " + player.health + " / 100");

            System.out.println("Enter your choice: ");
            String userInput = myScanner.nextLine();
            userInput = userInput.toUpperCase();

            if (player.currentRoom.enemy != null
                    && !(userInput.equals("U") || userInput.equals("I"))) {
                System.out
                        .println("You must deal with the enemy first!");
                continue; // skip switch and go back to top, requiring input "U"/"I"
            }

            switch (userInput) {
                case "F":
                    System.out.println("");
                    player.moveForward(game.getWorldRooms());
                    if (player.currentRoom.page != null) {
                        player.inventory.addItem(player.currentRoom.page);
                        System.out.println("You found a page in this room and added it to your inventory!");
                        player.currentRoom.page = null; // remove page from room after picking up
                        pageTracker.pageCollected();
                    }
                    if (player.currentRoom.enemy != null) {
                        System.out.println(
                                player.currentRoom.enemy.name + " is in this room!");
                    }
                    // if no weapon in inventory, and enemy in room, give one random weapon
                    if (player.inventory.getWeapon() == null && player.currentRoom.enemy != null) {
                        Item freeWeapon = ItemFactory.randomGoodWeapon();
                        player.inventory.addItem(freeWeapon);
                        System.out.println("You have no weapon to fight the " + player.currentRoom.enemy.name + ", so take this " + freeWeapon.name + ".");
                    }
                    break;
                case "B":
                    System.out.println("");
                    player.moveBack(game.getWorldRooms());
                    break;
                case "I":
                    System.out.println("");
                    player.inventory.display();
                    break;
                case "U":
                    System.out.println("");
                    boolean isWeaponUsed = player.use(myScanner, player.currentRoom.enemy);
                    if (isWeaponUsed && player.currentRoom.enemy.health <= 0) {
                        System.out.println("You defeated " + player.currentRoom.enemy.name + "!");
                        player.currentRoom.enemy = null;
                    } else if (isWeaponUsed) {
                        System.out.println(player.currentRoom.enemy.name + "'s health: " + player.currentRoom.enemy.health
                                + "/100");
                        player.receiveAttack(player.currentRoom.enemy);
                    } else if (!isWeaponUsed) {
                        System.out.println("");
                    }
                    break;
                case "C":
                    System.out.println("");
                    if (player.currentRoom.chest != null) {
                        Item item = player.currentRoom.chest.takeItem();
                        player.inventory.addItem(item);
                        player.currentRoom.chest = null; // remove opened chest
                        System.out.println("You opened the chest and found: " + item.name);
                    } else {
                        System.out.println("There is no chest in this room to open!");
                    }
                    break;
                default:
                    System.out.println("");
                    System.out.println("Invalid input, try again: ");
            }
        }
        if (player.health <= 0) {
            System.out.println("Game over, you lost. Better luck next time!");
        } else {
            System.out.println("Congratulations, you won the game!");
        }

        player.calculateScore();

        myScanner.close();
    }

}