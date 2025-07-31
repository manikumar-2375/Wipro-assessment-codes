package wipro;

public class Wipro_32 {

    public static void main(String[] args) {

        try {
            int[] arr = new int[-5];

        } catch (NegativeArraySizeException e) {
            System.out.println("Caught NegativeArraySizeException");
            e.printStackTrace();
        }

        try {
            int[] arr2 = {1, 2, 3};
            System.out.println(arr2[5]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException");
            e.printStackTrace();
        }

        try {
            String str = "Java";
            System.out.println(str.charAt(10));

        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException");
            e.printStackTrace();
        }

        try {
            java.util.ArrayList<Integer> list = new java.util.ArrayList<>();
            list.add(10);
            System.out.println(list.get(5));

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught IndexOutOfBoundsException");
            e.printStackTrace();
        }

        try {
            String nullString = null;
            System.out.println(nullString.length());

        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException");
            e.printStackTrace();
        }

        try {
            int a = 10 / 0;

        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException");
            e.printStackTrace();
        }

    }
}
/*Caught NegativeArraySizeException
java.lang.NegativeArraySizeException: -5
	at wipro/wipro.Wipro_32.main(Wipro_32.java:8)
Caught ArrayIndexOutOfBoundsException
java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 3
	at wipro/wipro.Wipro_32.main(Wipro_32.java:17)
Caught StringIndexOutOfBoundsException
java.lang.StringIndexOutOfBoundsException: Index 10 out of bounds for length 4
	at java.base/jdk.internal.util.Preconditions$1.apply(Preconditions.java:55)
	at java.base/jdk.internal.util.Preconditions$1.apply(Preconditions.java:52)
	at java.base/jdk.internal.util.Preconditions$4.apply(Preconditions.java:213)
	at java.base/jdk.internal.util.Preconditions$4.apply(Preconditions.java:210)
	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:98)
	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
	at java.base/java.lang.String.checkIndex(String.java:4832)
	at java.base/java.lang.StringLatin1.charAt(StringLatin1.java:46)
	at java.base/java.lang.String.charAt(String.java:1555)
	at wipro/wipro.Wipro_32.main(Wipro_32.java:26)
Caught IndexOutOfBoundsException
java.lang.IndexOutOfBoundsException: Index 5 out of bounds for length 1
	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
	at java.base/java.util.Objects.checkIndex(Objects.java:385)
	at java.base/java.util.ArrayList.get(ArrayList.java:427)
	at wipro/wipro.Wipro_32.main(Wipro_32.java:36)
Caught NullPointerException
java.lang.NullPointerException: Cannot invoke "String.length()" because "nullString" is null
	at wipro/wipro.Wipro_32.main(Wipro_32.java:45)
Caught ArithmeticException
java.lang.ArithmeticException: / by zero
	at wipro/wipro.Wipro_32.main(Wipro_32.java:53)
*/