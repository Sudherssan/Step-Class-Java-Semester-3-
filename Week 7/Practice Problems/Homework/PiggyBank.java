
import java.util.*;

public class PiggyBank {

    // Private savings: cannot be modified directly from outside
    private double savings;

    // Final ID: assigned once in the constructor
    private final String bankId;

    // Constructor
    public PiggyBank(String bankId) {
        this.bankId = bankId;
        this.savings = 0;
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit rejected: amount must be positive");
        } else {
            savings += amount;
            System.out.println("Savings after deposit: " + savings);
        }
    }

    // Withdraw money
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal rejected: amount must be positive");
        } else if (amount > savings) {
            System.out.println("Withdrawal rejected: insufficient savings");
        } else {
            savings -= amount;
            System.out.println("Savings after withdrawal: " + savings);
        }
    }

    // Read-only access to savings
    public double getSavings() {
        return savings;
    }

    // Read-only access to ID
    public String getBankId() {
        return bankId;
    }

    public static void main(String[] args) {

        PiggyBank pb = new PiggyBank("PB-1");

        pb.deposit(100);
        pb.withdraw(30);
        pb.withdraw(500);

        System.out.println("Piggy Bank ID: " + pb.getBankId());
        System.out.println("Final savings: " + pb.getSavings());
    }
}
