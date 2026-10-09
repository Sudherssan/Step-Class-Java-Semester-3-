
import java.util.*;

interface BusUser {
}

abstract class Student {
    protected String name;

    private static final double TRANSPORT_FEE = 12000.0;

    Student(String name) {
        this.name = name;
    }

    abstract double calculateTuition();
    abstract double calculateOtherFees();

    final double calculateTotalFee() {
        double total = calculateTuition() + calculateOtherFees();

        if (this instanceof BusUser) {
            total += TRANSPORT_FEE;
        }

        return total;
    }
}

class DayScholar extends Student implements BusUser {
    DayScholar(String name) {
        super(name);
    }

    double calculateTuition() {
        return 40000.0;
    }

    double calculateOtherFees() {
        return 0.0;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double calculateTuition() {
        return 40000.0;
    }

    double calculateOtherFees() {
        return 60000.0;
    }
}

class ScholarshipStudent extends Student implements BusUser {
    ScholarshipStudent(String name) {
        super(name);
    }

    double calculateTuition() {
        return 20000.0;
    }

    double calculateOtherFees() {
        return 0.0;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();

            switch (type) {
                case "DAY_SCHOLAR":
                    students.add(new DayScholar(name));
                    break;
                case "HOSTELLER":
                    students.add(new Hosteller(name));
                    break;
                case "SCHOLAR":
                    students.add(new ScholarshipStudent(name));
                    break;
                default:
                    throw new IllegalArgumentException("Invalid student type");
            }
        }

        double totalCollected = 0.0;

        for (Student student : students) {
            double fee = student.calculateTotalFee();
            System.out.printf("%s: %.2f%n", student.name, fee);
            totalCollected += fee;
        }

        System.out.printf("Total Collected: %.2f%n", totalCollected);
        sc.close();
    }
}
