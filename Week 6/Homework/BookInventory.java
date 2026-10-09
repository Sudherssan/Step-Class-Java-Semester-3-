
import java.util.*;

public class BookInventory {

    String title;
    String author;
    int copiesAvailable;

    // Constructor
    public BookInventory(String title, String author, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    // Instance method to print book details
    public void printEntry() {
        System.out.println(title + " by " + author + " - "
                + copiesAvailable + " copies available");
    }

    public static void main(String[] args) {

        // Create an array of four BookInventory objects
        BookInventory[] books = {
            new BookInventory("Clean Code", "Robert C. Martin", 3),
            new BookInventory("Effective Java", "Joshua Bloch", 5),
            new BookInventory("Refactoring", "Martin Fowler", 0),
            new BookInventory("Design Patterns", "GoF", 2)
        };

        // Print every book entry
        for (int i = 0; i < books.length; i++) {
            books[i].printEntry();
        }
    }
}
