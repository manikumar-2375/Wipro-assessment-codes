package wipro;

import java.util.*;

public class Wipro_26 {

	public static void main(String[] args) {
		
		int[] input = {2, 3, 54, 1, 6, 7, 7};

        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int num : input) {
            uniqueNumbers.add(num);
        }

        System.out.println("Unique elements: " + uniqueNumbers);

        int sum = 0;
        for (int num : uniqueNumbers) {
            if (num % 2 == 0) {
                sum += num;
            }
        }

        System.out.println("Sum of even numbers: " + sum);


	}

}
/*Unique elements: [1, 2, 3, 54, 6, 7]
Sum of even numbers: 62
*/