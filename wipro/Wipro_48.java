package wipro;

// Functional interface
@FunctionalInterface
interface EmployeeProcessor {
    void process(Employee_6 e);
}

// Employee class
class Employee_6 {
    int id;
    String name;
    double salary;

    public Employee_6(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
}

// Main class
public class Wipro_48 {
    public static void main(String[] args) {
        Employee_6 emp1 = new Employee_6(101, "Ravi", 50000);
        Employee_6 emp2 = new Employee_6(102, "Anita", 65000);

        // Print name and salary
        EmployeeProcessor printDetails = (e) -> {
            System.out.println("Name: " + e.name + ", Salary: " + e.salary);
        };

        // Calculate and print bonus
        EmployeeProcessor bonusCalculator = (e) -> {
            double bonus = e.salary * 0.10;
            System.out.println("Bonus for " + e.name + ": " + bonus);
        };

        // Process emp1
        printDetails.process(emp1);
        bonusCalculator.process(emp1);

        System.out.println();

        // Process emp2
        printDetails.process(emp2);
        bonusCalculator.process(emp2);
    }
}
/*Name: Ravi, Salary: 50000.0
Bonus for Ravi: 5000.0

Name: Anita, Salary: 65000.0
Bonus for Anita: 6500.0
*/