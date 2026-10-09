
import java.util.*;

interface Room {
    double calculateBill(int units);
}

class SingleRoom implements Room {
    public double calculateBill(int units) {
        return units * 8.0;
    }
}

class SharedRoom implements Room {
    private int occupants;

    SharedRoom(int occupants) {
        this.occupants = occupants;
    }

    public double calculateBill(int units) {
        return (units * 6.0) / occupants;
    }
}

class ACRoom implements Room {
    public double calculateBill(int units) {
        return units * 10.0 + 200.0;
    }
}

public class HostelElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            int units = sc.nextInt();

            Room room;

            switch (type) {
                case "SINGLE":
                    room = new SingleRoom();
                    break;

                case "SHARED":
                    int occupants = sc.nextInt();
                    room = new SharedRoom(occupants);
                    break;

                case "AC":
                    room = new ACRoom();
                    break;

                default:
                    throw new IllegalArgumentException("Invalid room type");
            }

            double bill = room.calculateBill(units);

            System.out.printf("%s: %.2f%n", type, bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
