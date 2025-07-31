package wipro;

import java.util.Scanner;

public class Wipro_9 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double totalAmount = 0.0;

        while (true) {
            System.out.print("Enter product number (1-3), or 0 to finish: ");
            int productNumber = scanner.nextInt();

            if (productNumber == 0) {
                break;
            }

            System.out.print("Enter quantity sold: ");
            int quantity = scanner.nextInt();

            double price = 0.0;

            switch (productNumber) {
                case 1:
                    price = 22.50;
                    break;
                case 2:
                    price = 44.50;
                    break;
                case 3:
                    price = 9.98;
                    break;
                default:
                    System.out.println("Invalid product number!");
                    continue;
            } // ✅ closing switch here

            totalAmount += price * quantity;
        }

        System.out.println("Total retail value of all products sold: ₹" + totalAmount);

        scanner.close();
    }
}
/*Enter product number (1-3), or 0 to finish: 2
Enter quantity sold: 6
Enter product number (1-3), or 0 to finish: 3
Enter quantity sold: 5
Enter product number (1-3), or 0 to finish: 0
Total retail value of all products sold: ₹316.9
*/