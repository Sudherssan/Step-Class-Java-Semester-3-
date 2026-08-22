import java.util.Scanner;

public class FileExtensionValidator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file name: ");
        String fileName = sc.nextLine();

        int dotPosition = fileName.lastIndexOf('.');

        if (dotPosition != -1 && dotPosition < fileName.length() - 1) {

            String extension = fileName.substring(dotPosition + 1);

            if (extension.equalsIgnoreCase("pdf") ||
                extension.equalsIgnoreCase("docx") ||
                extension.equalsIgnoreCase("zip")) {

                System.out.println("Accepted");

            } else {
                System.out.println("Rejected — invalid file type");
            }

        } else {
            System.out.println("Rejected — invalid file type");
        }

        sc.close();
    }
}
