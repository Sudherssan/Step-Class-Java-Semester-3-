
import java.util.*;

public class Locker {

    // Private combination: no getter is provided
    private String combinationCode;

    // Final locker number: fixed at creation
    private final int lockerNumber;

    // Constructor
    public Locker(int lockerNumber, String combinationCode) {
        this.lockerNumber = lockerNumber;
        this.combinationCode = combinationCode;
    }

    // Change code only if the current code is correct
    public void changeCode(String currentCode, String newCode) {
        if (combinationCode.equals(currentCode)) {
            combinationCode = newCode;
            System.out.println("Code changed successfully");
        } else {
            System.out.println("Code change rejected: incorrect current code");
        }
    }

    // Read-only access to locker number
    public int getLockerNumber() {
        return lockerNumber;
    }

    public static void main(String[] args) {

        Locker l = new Locker(101, "1234");

        // Correct current code
        l.changeCode("1234", "5678");

        // Incorrect current code
        l.changeCode("0000", "9999");

        System.out.println("Locker number: " + l.getLockerNumber());
    }
}
