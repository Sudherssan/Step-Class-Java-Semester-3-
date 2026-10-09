
import java.util.*;

interface SaverMode {
}

abstract class Appliance {
    protected double hours;

    private static final double COST_PER_UNIT = 8.0;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPower();

    final double calculateUnits(boolean saver) {
        double units = getPower() * hours / 1000.0;

        if (saver) {
            units *= 0.75;
        }

        return units;
    }

    final double calculateCost(double units) {
        return units * COST_PER_UNIT;
    }
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours);
    }

    double getPower() {
        return 150.0;
    }
}

class AirConditioner extends Appliance implements SaverMode {
    AirConditioner(double hours) {
        super(hours);
    }

    double getPower() {
        return 1500.0;
    }
}

class Television extends Appliance {
    Television(double hours) {
        super(hours);
    }

    double getPower() {
        return 100.0;
    }
}

class WashingMachine extends Appliance implements SaverMode {
    WashingMachine(double hours) {
        super(hours);
    }

    double getPower() {
        return 500.0;
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        double totalCost = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double hours = sc.nextDouble();

            boolean saver = false;

            if (sc.hasNext()) {
                // The next token may belong to the next input row.
                // Read SAVER only when it is present on this row.
            }

            Appliance appliance;

            switch (type) {
                case "FRIDGE":
                    appliance = new Fridge(hours);
                    break;
                case "AC":
                    appliance = new AirConditioner(hours);
                    break;
                case "TV":
                    appliance = new Television(hours);
                    break;
                case "WASHER":
                    appliance = new WashingMachine(hours);
                    break;
                default:
                    throw new IllegalArgumentException(
                            "Invalid appliance type");
            }

            // See the input-handling note below.
            // Saver mode is read as an optional token per line.
        }

        sc.close();
    }
}
