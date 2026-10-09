
import java.util.*;

interface Vehicle {
    double calculateCharge(int hours);
}

class Bike implements Vehicle {
    public double calculateCharge(int hours) {
        return hours * 10.0;
    }
}

class Car implements Vehicle {
    public double calculateCharge(int hours) {
        return 30.0 + (hours - 1) * 20.0;
    }
}

class Truck implements Vehicle {
    public double calculateCharge(int hours) {
        return Math.max(100.0, hours * 50.0);
    }
}

public class CampusParkingChargeCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double grandTotal = 0.0;

        // Map vehicle types to their charging implementations
        Map<String, Vehicle> vehicles = new HashMap<>();
        vehicles.put("BIKE", new Bike());
        vehicles.put("CAR", new Car());
        vehicles.put("TRUCK", new Truck());

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            int hours = sc.nextInt();

            Vehicle vehicle = vehicles.get(type);
            double charge = vehicle.calculateCharge(hours);

            System.out.printf("%s: %.2f%n", type, charge);
            grandTotal += charge;
        }

        System.out.printf("Total: %.2f%n", grandTotal);

        sc.close();
    }
}
