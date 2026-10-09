
import java.util.*;

public class NameTag {

    // Final fields: cannot be reassigned after initialization
    private final String firstName;
    private final String lastName;

    // Constructor
    public NameTag(String fullName) {
        String[] parts = fullName.split(" ");

        this.firstName = parts[0];
        this.lastName = parts[1];
    }

    // Return the nickname
    public String getNickname() {
        return firstName + " " + lastName.charAt(0) + ".";
    }

    public static void main(String[] args) {

        NameTag tag = new NameTag("Maria Gomez");

        System.out.println(tag.getNickname());

        // Another object with the same full name
        NameTag tag2 = new NameTag("Maria Gomez");

        System.out.println(tag2.getNickname());

        // They are separate objects
        System.out.println("Same object: " + (tag == tag2));
    }
}
