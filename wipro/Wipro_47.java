package wipro;

// Custom checked exception
class InvalidSalaryException extends Exception {
    public InvalidSalaryException(String message) {
        super(message);
    }
}

// Employee class
class Employee_5 {
    int id;
    String name;
    double salary;

    public Employee_5(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
}

// Service class
class EmployeeService {

    public void validateSalary(double salary) throws InvalidSalaryException {
        if (salary < 0) {
            throw new InvalidSalaryException("Salary cannot be negative: " + salary);
        }
    }

    public void processSalary(Employee_5 emp) throws InvalidSalaryException {
        validateSalary(emp.salary);
        System.out.println("Processing salary for " + emp.name);
    }

    public void startProcess(Employee_5 emp) throws InvalidSalaryException {
        processSalary(emp);
    }
}

// Main class
public class Wipro_47 {
    public static void main(String[] args) {
        Employee_5 emp = new Employee_5(101, "Karthik", -25000);

        EmployeeService service = new EmployeeService();

        try {
            service.startProcess(emp);
        } catch (InvalidSalaryException e) {
            System.out.println("Exception caught: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
/*Exception caught: Salary cannot be negative: -25000.0
wipro.InvalidSalaryException: Salary cannot be negative: -25000.0
	at wipro/wipro.EmployeeService.validateSalary(Wipro_47.java:28)
	at wipro/wipro.EmployeeService.processSalary(Wipro_47.java:33)
	at wipro/wipro.EmployeeService.startProcess(Wipro_47.java:38)
	at wipro/wipro.Wipro_47.main(Wipro_47.java:50)
*/