
import java.util.*;

abstract class Ticket {
    protected int count;
    private static final double CONVENIENCE_FEE = 20.0;

    Ticket(int count) {
        this.count = count;
    }

    abstract double getPrice();

    double calculateTotal() {
        return count * (getPrice() + CONVENIENCE_FEE);
    }
}

class RegularTicket extends Ticket {
    RegularTicket(int count) {
        super(count);
    }

    double getPrice() {
        return 150.0;
    }
}

class PremiumTicket extends Ticket {
    PremiumTicket(int count) {
        super(count);
    }

    double getPrice() {
        return 250.0;
    }
}

class ReclinerTicket extends Ticket {
    ReclinerTicket(int count) {
        super(count);
    }

    double getPrice() {
        return 400.0;
    }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Ticket> tickets = new ArrayList<>();
        List<String> seats = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String seat = sc.next().toUpperCase();
            int count = sc.nextInt();

            switch (seat) {
                case "REGULAR":
                    tickets.add(new RegularTicket(count));
                    break;
                case "PREMIUM":
                    tickets.add(new PremiumTicket(count));
                    break;
                case "RECLINER":
                    tickets.add(new ReclinerTicket(count));
                    break;
                default:
                    throw new IllegalArgumentException("Invalid seat type");
            }

            seats.add(seat);
        }

        double total = 0.0;

        for (int i = 0; i < n; i++) {
            double amount = tickets.get(i).calculateTotal();
            System.out.printf("%s: %.2f%n", seats.get(i), amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
