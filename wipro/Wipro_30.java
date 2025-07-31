package wipro;
import java.util.Scanner;



@FunctionalInterface
interface MinimumFinder {
    float minimum3(float a, float b, float c);
}

class Util {
    public static float minOfThree(float a, float b, float c) {
        return Math.min(a, Math.min(b, c));
    }
}

public class Wipro_30 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        float a = sc.nextFloat();

        System.out.print("Enter second number: ");
        float b = sc.nextFloat();

        System.out.print("Enter third number: ");
        float c = sc.nextFloat();

        MinimumFinder finder = Util::minOfThree;

        float min = finder.minimum3(a, b, c);

        System.out.println("The smallest number is: " + min);

        sc.close();
    }
}
/*Enter first number: 5.7
Enter second number: 8.9
Enter third number: 9.7
The smallest number is: 5.7
*/