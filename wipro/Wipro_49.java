package wipro;

import java.util.Optional;

// Custom Exception
class MissingFieldException extends Exception {
    public MissingFieldException(String message) {
        super(message);
    }
}

// Employee class
class Employee_7 {
    private int id;
    private String name;
    private Optional<String> email;
    private Optional<String> department;

    public Employee_7(int id, String name, Optional<String> email, Optional<String> department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
    }

    public void displayDetails() throws MissingFieldException {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);

        // If email is present, print; else print default
        System.out.println("Email: " + email.orElse("noemail@company.com"));

        // If department is not present, throw exception
        System.out.println("Department: " + department.orElseThrow(() ->
            new MissingFieldException("Department is required for employee " + name)
        ));
    }
}

// Main class
public class Wipro_49 {
    public static void main(String[] args) {
        try {
            // Employee with all fields
            Employee_7 emp1 = new Employee_7(1, "Kiran", Optional.of("kiran@example.com"), Optional.of("HR"));

            // Employee with no email
            Employee_7 emp2 = new Employee_7(2, "Meena", Optional.empty(), Optional.of("Finance"));

            // Employee with no department (should throw exception)
            Employee_7 emp3 = new Employee_7(3, "Raj", Optional.of("raj@example.com"), Optional.empty());

            emp1.displayDetails();
            System.out.println("---------------");
            emp2.displayDetails();
            System.out.println("---------------");
            emp3.displayDetails(); // This will throw MissingFieldException

        } catch (MissingFieldException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
/*ID: 1
Name: Kiran
Email: kiran@example.com
Department: HR
---------------
ID: 2
Name: Meena
Email: noemail@company.com
Department: Finance
---------------
ID: 3
Name: Raj
Email: raj@example.com
Error: Department is required for employee Raj
*/