package wipro;

import java.util.Scanner;

public class Wipro_8 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

       
        System.out.print("Enter number of classes held: ");
        int total_Classes = scanner.nextInt();

        System.out.print("Enter number of classes attended: ");
        int attended_Classes = scanner.nextInt();

        
        double attendance_Percent = (attended_Classes * 100.0) / total_Classes;
        System.out.println("Attendance Percentage: " + attendance_Percent + "%");

        
        if (attendance_Percent >= 70) {
            System.out.println("You are allowed to sit in the exam.");
        } else {
           
            System.out.print("Do you have a medical cause? (Y/N): ");
            char medicalCause = scanner.next().charAt(0);

            if (medicalCause == 'Y' || medicalCause == 'y') {
                System.out.println("You are allowed to sit in the exam due to medical cause.");
            } else {
                System.out.println("You are NOT allowed to sit in the exam.");
            }
        }

        scanner.close();
		// TODO Auto-generated method stub

	}

}
/*Enter number of classes held: 60
Enter number of classes attended: 20
Attendance Percentage: 33.333333333333336%
Do you have a medical cause? (Y/N): y
You are allowed to sit in the exam due to medical cause.
*/