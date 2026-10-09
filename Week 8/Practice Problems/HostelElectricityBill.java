
import java.util.*;

interface Room {
    double calculateBill();
}

class SingleRoom implements Room {
    private int units;

    public SingleRoom(int units) {
        this.units = units;
    }

    public double calculateBill() {
        return units * 8.0;
    }
}

class SharedRoom implements Room {
    private int units;
    private int occupants;

    public SharedRoom(int units, int occupants) {
        this.units = units;
        this.occupants = occupants;
    }

    public double calculateBill() {
        return (units * 6.0) / occupants;
    }
}

class ACRoom implements Room {
    private int units;

    public ACRoom(int units) {
        this.units = units;
    }

    public double calculateBill() {
        return units * 10.0 + 200.0;
    }
}

public class HostelElectricityBill {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            int units = sc.nextInt();

            Room room;

            // Create the appropriate room object
            switch (type) {
                case "SINGLE":
                    room = new SingleRoom(units);
                    break;

                case "SHARED":
                    int occupants = sc.nextInt();
                    room = new SharedRoom(units, occupants);
                    break;

                case "AC":
                    room = new ACRoom(units);
                    break;

                default:
                    throw new IllegalArgumentException("Invalid room type");
            }

            double bill = room.calculateBill();

            System.out.printf("%s: %.2f%n", type, bill);
            grandTotal += bill;
        }

        System.out.printf("Total: %.2f%n", grandTotal);

        sc.close();
    }
}
