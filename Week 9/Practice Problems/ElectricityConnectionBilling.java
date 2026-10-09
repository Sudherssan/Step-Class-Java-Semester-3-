
import java.util.*;

abstract class Connection {
    protected int units;

    Connection(int units) {
        this.units = units;
    }

    abstract double calculateBill();
}

class Home extends Connection {
    Home(int units) {
        super(units);
    }

    double calculateBill() {
        if (units <= 100) {
            return units * 5.0;
        }
        return 100 * 5.0 + (units - 100) * 7.0;
    }
}

class Shop extends Connection {
    Shop(int units) {
        super(units);
    }

    double calculateBill() {
        return units * 8.0 + 100.0;
    }
}

class Factory extends Connection {
    Factory(int units) {
        super(units);
    }

    double calculateBill() {
        return Math.max(units * 6.0, 1000.0);
    }
}

public class ElectricityConnectionBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Connection> connections = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            int units = sc.nextInt();

            switch (type) {
                case "HOME":
                    connections.add(new Home(units));
                    break;
                case "SHOP":
                    connections.add(new Shop(units));
                    break;
                case "FACTORY":
                    connections.add(new Factory(units));
                    break;
                default:
                    throw new IllegalArgumentException(
                            "Invalid connection type");
            }
        }

        double total = 0.0;

        for (Connection connection : connections) {
            double bill = connection.calculateBill();

            String type = connection instanceof Home ? "HOME"
                    : connection instanceof Shop ? "SHOP" : "FACTORY";

            System.out.printf("%s: %.2f%n", type, bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
