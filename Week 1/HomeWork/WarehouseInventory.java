import java.util.Scanner;

public class WarehouseInventory {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] sectionA = new int[5];
        int[] sectionB = new int[5];

        System.out.println("Enter stock quantities for Section A:");

        for (int i = 0; i < 5; i++) {
            System.out.print("Item " + (i + 1) + ": ");
            sectionA[i] = sc.nextInt();
        }

        System.out.println("\nEnter stock quantities for Section B:");

        for (int i = 0; i < 5; i++) {
            System.out.print("Item " + (i + 1) + ": ");
            sectionB[i] = sc.nextInt();
        }

        int totalA = 0;
        int totalB = 0;

        for (int i = 0; i < 5; i++) {
            totalA += sectionA[i];
            totalB += sectionB[i];
        }

        System.out.println("\nInventory Report");
        System.out.println("================");
        System.out.println("Section A Total: " + totalA);
        System.out.println("Section B Total: " + totalB);

        if (totalA == totalB) {
            System.out.println("Inventory Status: Balanced");
        } else {
            System.out.println("Inventory Status: Not Balanced");
        }

        int highestQuantity = sectionA[0];
        char highestSection = 'A';
        int highestPosition = 1;

        for (int i = 1; i < 5; i++) {
            if (sectionA[i] > highestQuantity) {
                highestQuantity = sectionA[i];
                highestSection = 'A';
                highestPosition = i + 1;
            }
        }

        for (int i = 0; i < 5; i++) {
            if (sectionB[i] > highestQuantity) {
                highestQuantity = sectionB[i];
                highestSection = 'B';
                highestPosition = i + 1;
            }
        }

        System.out.println("\nHighest Stock Quantity");
        System.out.println("======================");
        System.out.println("Quantity : " + highestQuantity);
        System.out.println("Section  : " + highestSection);
        System.out.println("Item     : " + highestPosition);

        sc.close();
    }
}