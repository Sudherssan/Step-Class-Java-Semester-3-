
import java.util.*;

public class HallTicket {

    String studentName;
    int seatNumber;

    // Constructor
    public HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }

    public static void main(String[] args) {

        // Create one HallTicket object for Priya
        HallTicket priya = new HallTicket("Priya", 0);

        // Second variable refers to the same object
        HallTicket copy = priya;

        // Change seat number through the second reference
        copy.seatNumber = 45;

        // Create a separate object with identical field values
        HallTicket separate = new HallTicket("Priya", 45);

        // Display results
        System.out.println(
            "Priya's seatNumber (via first variable):"
        );
        System.out.println(priya.seatNumber);

        System.out.println("copy == priya: " + (copy == priya));

        System.out.println("separate == priya: " + (separate == priya));
    }
}
