package wipro;

@FunctionalInterface
interface PerformOperation {
    boolean check(int num);
}

public class Wipro_28 {
    public static PerformOperation isOdd() {
        return num -> num % 2 != 0;
    }

    public static PerformOperation isPrime() {
        return num -> {
            if (num < 2) return false;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0)
                    return false;
            }
            return true;
        };
    }

    public static PerformOperation isPalindrome() {
        return num -> {
            int original = num, reversed = 0;
            while (num != 0) {
                reversed = reversed * 10 + num % 10;
                num /= 10;
            }
            return original == reversed;
        };
    }

	public static void main(String[] args) {
		
		int test1 = 5;
        int test2 = 17;
        int test3 = 121;

        System.out.println("Is " + test1 + " Odd? " + isOdd().check(test1));
        System.out.println("Is " + test2 + " Prime? " + isPrime().check(test2));
        System.out.println("Is " + test3 + " Palindrome? " + isPalindrome().check(test3));

	}

}
/*Is 5 Odd? true
Is 17 Prime? true
Is 121 Palindrome? true
*/