
import java.util.*;

public class PasswordChecker {

    // Private and final: password cannot be changed after creation
    private final String password;

    // Constructor
    public PasswordChecker(String password) {
        this.password = password;
    }

    // Return only the password strength, never the password itself
    public String getStrength() {
        int length = password.length();

        if (length < 6) {
            return "Weak";
        } else if (length <= 9) {
            return "Medium";
        } else {
            return "Strong";
        }
    }

    public static void main(String[] args) {

        PasswordChecker pc1 = new PasswordChecker("abcd");
        PasswordChecker pc2 = new PasswordChecker("abcdefgh");
        PasswordChecker pc3 = new PasswordChecker("abcdefghijkl");

        System.out.println("Password 1 strength: " + pc1.getStrength());
        System.out.println("Password 2 strength: " + pc2.getStrength());
        System.out.println("Password 3 strength: " + pc3.getStrength());
    }
}
