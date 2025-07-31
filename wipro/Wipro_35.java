package wipro;

import java.util.Scanner;

// Custom Exception
class InvalidEmployeeCode extends Exception {
    public InvalidEmployeeCode(String message) {
        super(message);
    }
}

// Employee class
class Employee_1 {
    private String employeeCode;
    private String name;
    private int yearOfBirth;

    public Employee_1(String employeeCode, String name, int yearOfBirth) {
        this.employeeCode = employeeCode;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    public void display() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee Code: " + employeeCode);
        System.out.println("Year of Birth: " + yearOfBirth);
    }
}

// Main class
public class Wipro_35 {

    // Method to validate the code format: "yy-F-123" or "yy-S-123"
    public static boolean isValidCode(String code) {
        return code.matches("\\d{2}-[FS]-\\d{3}");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Read inputs
            System.out.print("Enter Employee Code (format yy-F-123): ");
            String code = sc.nextLine();

            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Year of Birth: ");
            int yob = sc.nextInt();

            // Validate code
            if (!isValidCode(code)) {
                throw new InvalidEmployeeCode("Invalid format! Expected format: yy-[F/S]-nnn");
            }

            // If valid, create and display employee
            Employee_1 emp = new Employee_1(code, name, yob);
            emp.display();

        } catch (InvalidEmployeeCode e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e);
        } finally {
            sc.close();
        }
    }
}
/*Enter Employee Code (format yy-F-123): 81-F-112
Enter Employee Name: Anil
Enter Year of Birth: 1960
Employee Name: Anil
Employee Code: 81-F-112
Year of Birth: 1960
*/