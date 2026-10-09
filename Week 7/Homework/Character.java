
import java.util.*;

public class Character {

    // Private health: cannot be changed directly from outside
    private int health;

    // Maximum health is fixed at creation
    private final int maxHealth;

    // Constructor
    public Character(int maxHealth) {
        if (maxHealth < 0) {
            throw new IllegalArgumentException(
                "Maximum health cannot be negative"
            );
        }

        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    // Reduce health without going below zero
    public void takeDamage(int amount) {
        if (amount <= 0) {
            System.out.println("Damage must be positive");
            return;
        }

        health = Math.max(0, health - amount);
    }

    // Increase health without exceeding maximum health
    public void heal(int amount) {
        if (amount <= 0) {
            System.out.println("Healing amount must be positive");
            return;
        }

        health = Math.min(maxHealth, health + amount);
    }

    // Read-only access to current health
    public int getHealth() {
        return health;
    }

    public static void main(String[] args) {

        Character c = new Character(100);

        c.takeDamage(30);
        System.out.println("Health after damage: " + c.getHealth());

        c.heal(50);
        System.out.println("Health after healing: " + c.getHealth());

        c.takeDamage(150);
        System.out.println("Health after final damage: " + c.getHealth());
    }
}
