
import java.util.*;

public class Employee {

    String empId;
    String empName;
    double salary;
    boolean isIntern;

    // Constructor for permanent employees
    public Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    // Constructor for interns using constructor chaining
    public Employee(String empId, String empName) {
        this(empId, empName, 0);
        this.isIntern = true;
    }

    // Print employee profile
    public void printProfile() {
        System.out.println(
            empId + " | " + empName + " | Rs " + salary
            + " | Intern: " + isIntern
        );
    }

    public static void main(String[] args) {

        // Permanent employee
        Employee e1 = new Employee("E-101", "Divya", 65000);

        // Intern employee
        Employee e2 = new Employee("E-102", "Arjun");

        // Print both profiles
        e1.printProfile();
        e2.printProfile();
    }
}
