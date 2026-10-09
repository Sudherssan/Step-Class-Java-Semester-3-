
import java.util.*;

public class AttendanceSheet {

    // Private array to store present student names
    private String[] presentStudents;

    // Number of students currently marked present
    private int presentCount;

    // Constructor
    public AttendanceSheet(int maxStudents) {
        if (maxStudents < 0) {
            throw new IllegalArgumentException(
                "Maximum students cannot be negative"
            );
        }

        presentStudents = new String[maxStudents];
        presentCount = 0;
    }

    // Mark a student present
    public void markPresent(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Invalid student name");
            return;
        }

        // Avoid duplicate names
        if (isPresent(name)) {
            return;
        }

        // Check whether the array is full
        if (presentCount >= presentStudents.length) {
            System.out.println("Attendance rejected: class is full");
            return;
        }

        presentStudents[presentCount] = name;
        presentCount++;
    }

    // Return the number of present students
    public int getPresentCount() {
        return presentCount;
    }

    // Check whether a specific student is present
    public boolean isPresent(String name) {
        if (name == null) {
            return false;
        }

        for (int i = 0; i < presentCount; i++) {
            if (presentStudents[i].equals(name)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        AttendanceSheet sheet = new AttendanceSheet(30);

        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println(
            "Present count: " + sheet.getPresentCount()
        );

        System.out.println(
            "Is Ben present? " + sheet.isPresent("Ben")
        );

        System.out.println(
            "Is Chen present? " + sheet.isPresent("Chen")
        );
    }
}
