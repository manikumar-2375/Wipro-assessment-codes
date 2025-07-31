package wipro;

public class Wipro_42 {

    // Method that initially throws an exception
    public static void someMethod2() throws Exception {
        throw new Exception("Exception thrown from someMethod2");
    }

    // Method that catches and rethrows the exception
    public static void someMethod() throws Exception {
        try {
            someMethod2();
        } catch (Exception e) {
            System.out.println("Exception caught in someMethod, rethrowing...");
            throw e; // Rethrow the same exception
        }
    }

    // Main method
    public static void main(String[] args) {
        try {
            someMethod();
        } catch (Exception e) {
            System.out.println("Exception caught in main:");
            e.printStackTrace(); // Print full stack trace
        }
    }
}
/*Exception caught in someMethod, rethrowing...
Exception caught in main:
java.lang.Exception: Exception thrown from someMethod2
	at wipro/wipro.Wipro_42.someMethod2(Wipro_42.java:7)
	at wipro/wipro.Wipro_42.someMethod(Wipro_42.java:13)
	at wipro/wipro.Wipro_42.main(Wipro_42.java:23)
*/