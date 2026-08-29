import java.util.Scanner;

public class SwitchOperator {

    static void calculate(double a, double b, char operator) {
        switch (operator) {
            case '+':
                System.out.println("Result: " + (a + b));
                break;
            case '-':
                System.out.println("Result: " + (a - b));
                break;
            case '*':
                System.out.println("Result: " + (a * b));
                break;
            case '/':
                if (b == 0)
                    System.out.println("Cannot divide by zero");
                else
                    System.out.println("Result: " + (a / b));
                break;
            default:
                System.out.println("Invalid operator");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double a = sc.nextDouble();
        double b = sc.nextDouble();
        char op = sc.next().charAt(0);

        calculate(a, b, op);
    }
}