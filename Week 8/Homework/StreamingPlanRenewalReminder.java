
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;

abstract class SubscriptionPlan {
    protected String name;
    protected LocalDate startDate;

    SubscriptionPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    abstract int getValidityDays();

    LocalDate getRenewalDate() {
        return startDate.plusDays(getValidityDays());
    }
}

class BasicPlan extends SubscriptionPlan {
    BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int getValidityDays() {
        return 30;
    }
}

class StandardPlan extends SubscriptionPlan {
    StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int getValidityDays() {
        return 90;
    }
}

class PremiumPlan extends SubscriptionPlan {
    PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int getValidityDays() {
        return 365;
    }
}

public class StreamingPlanRenewalReminder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Map<String, Function<String[], SubscriptionPlan>> factory =
                new HashMap<>();

        factory.put("BASIC", data ->
                new BasicPlan(data[0], LocalDate.parse(data[1], formatter)));

        factory.put("STANDARD", data ->
                new StandardPlan(data[0], LocalDate.parse(data[1], formatter)));

        factory.put("PREMIUM", data ->
                new PremiumPlan(data[0], LocalDate.parse(data[1], formatter)));

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();
            String date = sc.next();

            SubscriptionPlan plan = factory.get(type)
                    .apply(new String[]{name, date});

            LocalDate renewalDate = plan.getRenewalDate();

            System.out.println(name + ": " +
                    renewalDate.format(formatter));
        }

        sc.close();
    }
}
