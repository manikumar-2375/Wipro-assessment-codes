package wipro;

import java.util.Scanner;

public class Wipro_4 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter your name: ");
		
		String name = scanner.nextLine();
		
		System.out.print("Enter your roll number: ");
		
		String rollNumber = scanner.nextLine();
		
		System.out.print("Enter your field of interest: ");
		
		String interest = scanner.nextLine();
		
		System.out.println("my name is" + name + "and my roll number is" + rollNumber + "My field of interest are " + interest + ".");
		
		scanner.close();
		
		
		
		
		
	
		

	}

}
/*
Enter your name: manikumar
Enter your roll number: 361
Enter your field of interest: cse
my name is manikumar and my roll number is 361 My field of interest are cse.
*/
