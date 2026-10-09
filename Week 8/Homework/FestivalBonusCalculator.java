
import java.util.*;

abstract class Employee {
    protected String name;
    protected double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    abstract double calculateBonus();
}

class FullTimeEmployee extends Employee {
    FullTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    double calculateBonus() {
        return salary * 0.10;
    }
}

class PartTimeEmployee extends Employee {
    PartTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    double calculateBonus() {
        return salary * 0.05;
    }
}

class Intern extends Employee {
    Intern(String name, double salary) {
        super(name, salary);
    }

    double calculateBonus() {
        return 2000.0;
    }
}

public class FestivalBonusCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, java.util.function.BiFunction<String, Double, Employee>> factory =
                new HashMap<>();

        factory.put("FULLTIME", FullTimeEmployee::new);
        factory.put("PARTTIME", PartTimeEmployee::new);
        factory.put("INTERN", Intern::new);

        int n = sc.nextInt();
        double totalBonus = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();
            double salary = sc.nextDouble();

            Employee employee = factory.get(type).apply(name, salary);
            double bonus = employee.calculateBonus();

            System.out.printf("%s: %.2f%n", name, bonus);
            totalBonus += bonus;
        }

        System.out.printf("Total Bonus: %.2f%n", totalBonus);

        sc.close();
    }
}
