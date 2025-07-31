package wipro;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Wipro_31 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter an integer: ");
            int num = sc.nextInt(); 
            System.out.println("You entered: " + num);
        } catch (InputMismatchException e) {
            System.out.println("Caught InputMismatchException: Please enter a valid integer.");
            sc.nextLine(); 
        }

        try {
            System.out.print("Enter a word: ");
            String word = sc.nextLine();
            System.out.print("Enter index to access: ");
            int index = sc.nextInt();
            char ch = word.charAt(index);  
            System.out.println("Character at index " + index + ": " + ch);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException: Invalid index for the string.");
        }

        sc.close();
    }
}
/*Enter an integer: nm
Caught InputMismatchException: Please enter a valid integer.
Enter a word: mani
Enter index to access: 6
Caught StringIndexOutOfBoundsException: Invalid index for the string.
*/