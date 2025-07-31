package wipro;

import java.util.HashMap;  
import java.util.Map;


public class OccurrenceCounter_15 {

	public static void main(String[] args) {
        int[] numbers = {4, 2, 4, 5, 2, 3, 1, 4, 2, 5};

        Map<Integer, Integer> countMap = new HashMap<>();

        
        for (int num : numbers) {
          
            if (countMap.containsKey(num)) {
                countMap.put(num, countMap.get(num) + 1);
            } else {
                countMap.put(num, 1);
            }
        }

        System.out.println("Number -> Count");
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

	}

}
/*Number -> Count
1 -> 1
2 -> 3
3 -> 1
4 -> 3
5 -> 2
*/