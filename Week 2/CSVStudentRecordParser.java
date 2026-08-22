import java.util.Scanner;

public class CSVStudentRecordParser {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student record: ");
        String record = sc.nextLine();

        String[] fields = record.split(",");

        if (fields.length == 3) {

            System.out.println("\nStudent Record");
            System.out.println("==============");
            System.out.println("Name       : " + fields[0]);
            System.out.println("Roll No    : " + fields[1]);
            System.out.println("Department : " + fields[2]);

        } else {
            System.out.println("Invalid Record");
        }

        sc.close();
    }
}
