
import java.util.*;

class Employee {

    // Instance fields
    String empName;
    double salary;

    // Static fields shared by all employees
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    // Constructor
    public Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    // Static method
    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class CompanyEmployeeInfo {

    public static void main(String[] args) {

        // Create three Employee objects
        Employee e1 = new Employee("Ravi", 35000);
        Employee e2 = new Employee("Priya", 42000);
        Employee e3 = new Employee("Arjun", 30000);

        // Call static method using the class name
        Employee.printCompanyInfo();
    }
}
