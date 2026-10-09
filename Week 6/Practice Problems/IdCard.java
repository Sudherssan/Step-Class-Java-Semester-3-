
import java.util.*;

public class IdCard {

    String name;
    int booksIssued;

    // Constructor
    public IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }

    public static void main(String[] args) {

        // Create one IdCard object for Ravi
        IdCard ravi = new IdCard("Ravi", 0);

        // Second variable references the same object
        IdCard duplicate = ravi;

        // Modify the object through the second reference
        duplicate.booksIssued = 3;

        // Create a separate object with identical field values
        IdCard separate = new IdCard("Ravi", 3);

        // Print results
        System.out.println(
            "Ravi's booksIssued (via first variable): "
            + ravi.booksIssued
        );

        System.out.println("duplicate == ravi: " + (duplicate == ravi));

        System.out.println("separate == ravi: " + (separate == ravi));
    }
}
