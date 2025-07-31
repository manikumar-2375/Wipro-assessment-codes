package wipro;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Wipro_29 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Register Number: ");
            String regNo = sc.nextLine();

            System.out.print("Enter Mobile Number: ");
            String mobile = sc.nextLine();

            // Validate Register Number
            if (regNo.length() != 9) {
                throw new IllegalArgumentException("Register Number must be exactly 9 characters.");
            }

            if (!regNo.matches("[a-zA-Z0-9]+")) {
                throw new NoSuchElementException("Register Number contains invalid characters.");
            }

            // Validate Mobile Number
            if (mobile.length() != 10) {
                throw new IllegalArgumentException("Mobile Number must be exactly 10 digits.");
            }

            if (!mobile.matches("[0-9]+")) {
                throw new NumberFormatException("Mobile Number must contain only digits.");
            }

            System.out.println("valid");

        } catch (NoSuchElementException e) {
            System.out.println("invalid - Register Number contains invalid characters");
        } catch (NumberFormatException e) {
            System.out.println("invalid - Mobile Number contains non-digit characters");
        } catch (IllegalArgumentException e) {
            System.out.println("invalid - " + e.getMessage());
        }

        sc.close();
    }
}
/*Enter Register Number: cbnbmn23
Enter Mobile Number: 7032400223
invalid - Register Number must be exactly 9 characters.

*/
/*Enter Register Number: CBENU4361
Enter Mobile Number: 7032400223
valid
*/