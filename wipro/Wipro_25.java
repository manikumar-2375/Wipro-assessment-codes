package wipro;

import java.util.Scanner;

public class Wipro_25 {
	
    public static boolean isValid(double a, double b, double c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    public static double perimeter(double a, double b, double c) {
        return a + b + c;
    }

    public static double area(double a, double b, double c) {
        double s = (a + b + c) / 2.0; // semi-perimeter
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter side a (or -1 to exit): ");
            double a = scanner.nextDouble();

            if (a == -1) {
                System.out.println("Bye~");
                break;
            }

            System.out.print("Enter side b: ");
            double b = scanner.nextDouble();

            System.out.print("Enter side c: ");
            double c = scanner.nextDouble();

            if (isValid(a, b, c)) {
                double p = perimeter(a, b, c);
                double ar = area(a, b, c);
                System.out.printf("Perimeter = %.2f\n", p);
                System.out.printf("Area = %.2f\n", ar);
            } else {
                System.out.println("The input is invalid.");
            }

            System.out.println(); 
        }

        scanner.close();

	}

}
/*Enter side a (or -1 to exit): 7
Enter side b: 9
Enter side c: 6
Perimeter = 22.00
Area = 20.98

Enter side a (or -1 to exit): -1
Bye~
*/