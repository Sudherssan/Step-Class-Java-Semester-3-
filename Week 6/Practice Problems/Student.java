
import java.util.*;

public class Student {

    // Instance fields: separate for each student
    String name;
    int attendance;

    // Static fields: shared by all students
    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    // Constructor
    public Student(String name, int attendance) {
        this.name = name;
        this.attendance = attendance;

        // Increment count whenever an object is created
        studentCount++;
    }

    // Static method
    public static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }

    public static void main(String[] args) {

        // Create two Student objects
        Student s1 = new Student("Ravi", 85);
        Student s2 = new Student("Anitha", 90);

        // Call static method using the class name
        Student.printCollegeInfo();
    }
}
