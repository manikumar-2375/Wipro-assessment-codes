package wipro;

import java.util.Scanner;
public class Wipro_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter your salary: ");
        double salary = scanner.nextDouble();

        System.out.print("Enter your years of service: ");
        int years = scanner.nextInt();

        
        if (years > 6) {
            double bonus = salary * 0.10; 
            System.out.println("You are eligible for bonus. Bonus amount: " + bonus);
        } else {
            System.out.println("You are not eligible for bonus.");
        }

        scanner.close();

	}

}
/*
Enter your salary: 10000
Enter your years of service: 7
You are eligible for bonus. Bonus amount: 1000.0
*/