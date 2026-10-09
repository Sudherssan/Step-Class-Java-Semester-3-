
import java.util.*;

abstract class Booking {
    protected double distanceKm;
    private static final double BOOKING_FEE = 50.0;

    Booking(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    abstract double calculateFare();

    double calculateTotal() {
        return calculateFare() + BOOKING_FEE;
    }
}

class Bus extends Booking {
    Bus(double distanceKm) {
        super(distanceKm);
    }

    double calculateFare() {
        return distanceKm * 2.0;
    }
}

class Train extends Booking {
    Train(double distanceKm) {
        super(distanceKm);
    }

    double calculateFare() {
        return distanceKm * 1.5;
    }
}

class Flight extends Booking {
    Flight(double distanceKm) {
        super(distanceKm);
    }

    double calculateFare() {
        return 2500.0 + distanceKm * 4.0;
    }
}

public class TravelBookingWithCommonFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Booking> bookings = new ArrayList<>();
        List<String> modes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String mode = sc.next().toUpperCase();
            double distance = sc.nextDouble();

            switch (mode) {
                case "BUS":
                    bookings.add(new Bus(distance));
                    break;
                case "TRAIN":
                    bookings.add(new Train(distance));
                    break;
                case "FLIGHT":
                    bookings.add(new Flight(distance));
                    break;
                default:
                    throw new IllegalArgumentException("Invalid travel mode");
            }

            modes.add(mode);
        }

        for (int i = 0; i < n; i++) {
            double total = bookings.get(i).calculateTotal();
            System.out.printf("%s: %.2f%n", modes.get(i), total);
        }

        sc.close();
    }
}
