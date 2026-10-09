
import java.util.*;

public class TrafficLight {

    // Private color: cannot be changed directly from outside
    private String color;

    // Final ID: fixed when the object is created
    private final String lightId;

    // Constructor
    public TrafficLight(String lightId) {
        this.lightId = lightId;
        this.color = "RED";
    }

    // Move to the next color in the cycle
    public void next() {
        if (color.equals("RED")) {
            color = "GREEN";
        } else if (color.equals("GREEN")) {
            color = "YELLOW";
        } else {
            color = "RED";
        }
    }

    // Read-only access to the current color
    public String getColor() {
        return color;
    }

    // Read-only access to the light ID
    public String getLightId() {
        return lightId;
    }

    public static void main(String[] args) {

        TrafficLight t = new TrafficLight("TL-9");

        System.out.println(t.getColor());

        t.next();
        System.out.println(t.getColor());

        t.next();
        System.out.println(t.getColor());

        t.next();
        System.out.println(t.getColor());

        t.next();
        System.out.println(t.getColor());
    }
}
