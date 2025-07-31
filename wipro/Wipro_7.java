package wipro;

import java.util.Scanner;

public class Wipro_7 {

	public static void main(String[] args) {
		
		 Scanner scanner = new Scanner(System.in);

	        
	        System.out.print("number of classes held: ");
	        int total_Classes = scanner.nextInt();

	        System.out.print("number of classes attended: ");
	        int attended_Classes = scanner.nextInt();

	        
	        double attendance_Percent = (attended_Classes * 100.0) / total_Classes;

	        
	        System.out.println("Attendance Percentage: " + attendance_Percent + "%");

	        
	        if (attendance_Percent >= 70) {
	            System.out.println("You are allowed to sit in the exam.");
	        } else {
	            System.out.println("You are NOT allowed to sit in the exam.");
	        }

	        scanner.close();
		// TODO Auto-generated method stub

	}

}
/*number of classes held: 60
number of classes attended: 40
Attendance Percentage: 66.66666666666667%
You are NOT allowed to sit in the exam.
 */