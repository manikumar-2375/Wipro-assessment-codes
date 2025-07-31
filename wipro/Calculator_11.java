package wipro;

public class Calculator_11 {
	
	 void add(int a, int b) {
	        int result = a + b;
	        System.out.println("Addition: " + result);
	    }

	    
	    void diff(int a, int b) {
	        int result = a - b;
	        System.out.println("Difference: " + result);
	    }

	    void mul(int a, int b) {
	        int result = a * b;
	        System.out.println("Multiplication: " + result);
	    }

	    void div(int a, int b) {
	        if (b != 0) {
	            double result = (double) a / b;
	            System.out.println("Division: " + result);
	        } else {
	            System.out.println("Cannot divide by zero.");
	        }
	    }

	public static void main(String[] args) {
		
		 Calculator_11 calc = new Calculator_11(); 

	        int num1 = 20;
	        int num2 = 10;

	        
	        calc.add(num1, num2);
	        calc.diff(num1, num2);
	        calc.mul(num1, num2);
	        calc.div(num1, num2);
		

	}

}
/*Addition: 30
Difference: 10
Multiplication: 200
Division: 2.0
*/