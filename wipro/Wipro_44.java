package wipro;

import java.util.*;

class Employee_3 {
    int id;
    String name;
    double salary;

    public Employee_3(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

public class Wipro_44 {
    public static void main(String[] args) {
        List<Employee_3> empList = new ArrayList<>();

        empList.add(new Employee_3(101, "Ravi", 60000));
        empList.add(new Employee_3(102, "Anjali", 85000));
        empList.add(new Employee_3(103, "Bhavya", 75000));
        empList.add(new Employee_3(104, "Kiran", 60000));

        // Sort by salary descending
        empList.sort(new Comparator<Employee_3>() {
            public int compare(Employee_3 e1, Employee_3 e2) {
                return Double.compare(e2.salary, e1.salary);
            }
        });

        System.out.println("Employees sorted by salary (descending):");
        for (Employee_3 e : empList) {
            System.out.println(e);
        }

        // Sort by name using lambda (alphabetically)
        empList.sort((e1, e2) -> e1.name.compareTo(e2.name));

        System.out.println("\nEmployees sorted by name (alphabetically):");
        for (Employee_3 e : empList) {
            System.out.println(e);
        }
    }
}
/*Employees sorted by salary (descending):
ID: 102, Name: Anjali, Salary: 85000.0
ID: 103, Name: Bhavya, Salary: 75000.0
ID: 101, Name: Ravi, Salary: 60000.0
ID: 104, Name: Kiran, Salary: 60000.0

Employees sorted by name (alphabetically):
ID: 102, Name: Anjali, Salary: 85000.0
ID: 103, Name: Bhavya, Salary: 75000.0
ID: 104, Name: Kiran, Salary: 60000.0
ID: 101, Name: Ravi, Salary: 60000.0
*/