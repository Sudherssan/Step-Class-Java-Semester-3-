
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;

abstract class SubscriptionPlan {
    protected String name;
    protected LocalDate startDate;

    public SubscriptionPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public abstract int getValidityDays();

    public LocalDate getRenewalDate() {
        return startDate.plusDays(getValidityDays());
    }

    public String getName() {
        return name;
    }
}

class BasicPlan extends SubscriptionPlan {
    public BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public int getValidityDays() {
        return 30;
    }
}

class StandardPlan extends SubscriptionPlan {
    public StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public int getValidityDays() {
        return 90;
    }
}

class PremiumPlan extends SubscriptionPlan {
    public PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public int getValidityDays() {
        return 365;
    }
}

public class StreamingPlanRenewalReminder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Map<String, Function<String[], SubscriptionPlan>> planFactory =
                new HashMap<>();

        planFactory.put("BASIC", data ->
                new BasicPlan(data[0], LocalDate.parse(data[1], formatter)));

        planFactory.put("STANDARD", data ->
                new StandardPlan(data[0], LocalDate.parse(data[1], formatter)));

        planFactory.put("PREMIUM", data ->
                new PremiumPlan(data[0], LocalDate.parse(data[1], formatter)));

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();
            String date = sc.next();

            SubscriptionPlan plan =
                    planFactory.get(type).apply(new String[]{name, date});

            System.out.println(
                    plan.getName() + ": "
                    + plan.getRenewalDate().format(formatter)
            );
        }

        sc.close();
    }
}
