
import java.util.*;

abstract class Staff {
    protected String name;

    Staff(String name) {
        this.name = name;
    }

    abstract double calculatePay();
}

class FullTimeStaff extends Staff {
    private double weeklySalary;

    FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    double calculatePay() {
        return weeklySalary;
    }
}

class HourlyStaff extends Staff {
    private double hours, rate;

    HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        }
        return 40 * rate + (hours - 40) * rate * 1.5;
    }
}

class InternStaff extends Staff {
    private double stipend;

    InternStaff(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    double calculatePay() {
        return stipend;
    }
}

public class WeeklyStaffPay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Staff> staffList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();

            switch (type) {
                case "FULLTIME":
                    staffList.add(
                            new FullTimeStaff(name, sc.nextDouble()));
                    break;
                case "HOURLY":
                    staffList.add(new HourlyStaff(
                            name, sc.nextDouble(), sc.nextDouble()));
                    break;
                case "INTERN":
                    staffList.add(new InternStaff(name, sc.nextDouble()));
                    break;
                default:
                    throw new IllegalArgumentException("Invalid staff type");
            }
        }

        double totalPayroll = 0.0;

        for (Staff staff : staffList) {
            double pay = staff.calculatePay();
            System.out.printf("%s: %.2f%n", staff.name, pay);
            totalPayroll += pay;
        }

        System.out.printf("Total Payroll: %.2f%n", totalPayroll);
        sc.close();
    }
}
