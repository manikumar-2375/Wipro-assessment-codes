package wipro;

import java.util.Scanner;

public class StudentAverage_16 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
        int mark;
        int total = 0;
        int studentCount = 3;

        for (int i = 1; i <= studentCount; i++) {
            while (true) {
                System.out.print("Enter the mark (0-100) for student " + i + ": ");
                mark = scanner.nextInt();

               
                if (mark >= 0 && mark <= 100) {
                    total += mark;
                    break; 
                } else {
                    System.out.println("Invalid input, try again...");
                }
            }
        }

        double average = (double) total / studentCount;

        System.out.printf("The average is: %.2f\n", average);

        scanner.close();

	}

}
/*Enter the mark (0-100) for student 1: 56
Enter the mark (0-100) for student 2: 67
Enter the mark (0-100) for student 3: 78
The average is: 67.00
*/