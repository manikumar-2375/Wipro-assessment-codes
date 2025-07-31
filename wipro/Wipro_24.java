package wipro;

import java.util.Scanner;

public class Wipro_24 {

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
	        int[] speeds = new int[5];
	        int total = 0;

	        System.out.println("Enter speed of 5 bikers:");
	        for (int i = 0; i < 5; i++) {
	            System.out.print("Speed of Biker " + (i + 1) + ": ");
	            speeds[i] = scanner.nextInt();
	            total += speeds[i]; 
	        }

	        double average = total / 5.0;

	        System.out.println("\nAverage speed: " + average);
	        System.out.println("Qualifying bikers (speed > average):");
	        boolean found = false;
	        for (int speed : speeds) {
	            if (speed > average) {
	                System.out.println(speed);
	                found = true;
	            }
	        }

	        if (!found) {
	            System.out.println("No biker qualified.");
	        }

	        scanner.close();

	}

}
/*Enter speed of 5 bikers:
Speed of Biker 1: 56
Speed of Biker 2: 67
Speed of Biker 3: 89
Speed of Biker 4: 89
Speed of Biker 5: 90

Average speed: 78.2
Qualifying bikers (speed > average):
89
89
90
*/