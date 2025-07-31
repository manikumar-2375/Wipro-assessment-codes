package wipro;

import java.util.*;

// Generic Repository class
class Repository<T, ID> {
    private Map<ID, T> storage = new HashMap<>();

    public void save(ID id, T entity) {
        storage.put(id, entity);
    }

    public T findById(ID id) {
        return storage.get(id);
    }

    public List<T> findAll() {
        return new ArrayList<>(storage.values());
    }

    public void deleteById(ID id) {
        storage.remove(id);
    }
}

// Employee class
class Employee_4 {
    int id;
    String name;
    double salary;

    public Employee_4(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: ₹" + salary;
    }
}

public class Wipro_46 {
    public static void main(String[] args) {
        // Create repository for Employee with Integer as ID
        Repository<Employee_4, Integer> repo = new Repository<>();

        // Add 3 employees
        repo.save(1, new Employee_4(1, "Ravi", 50000));
        repo.save(2, new Employee_4(2, "Anjali", 60000));
        repo.save(3, new Employee_4(3, "Kiran", 55000));

        // Retrieve and print all employees
        System.out.println("All Employees:");
        repo.findAll().forEach(System.out::println);

        // Retrieve and print employee by ID
        System.out.println("\nEmployee with ID 2:");
        System.out.println(repo.findById(2));

        // Delete employee with ID 1
        repo.deleteById(1);
        System.out.println("\nAfter deleting employee with ID 1:");
        repo.findAll().forEach(System.out::println);
    }
}
/*All Employees:
ID: 1, Name: Ravi, Salary: ₹50000.0
ID: 2, Name: Anjali, Salary: ₹60000.0
ID: 3, Name: Kiran, Salary: ₹55000.0

Employee with ID 2:
ID: 2, Name: Anjali, Salary: ₹60000.0

After deleting employee with ID 1:
ID: 2, Name: Anjali, Salary: ₹60000.0
ID: 3, Name: Kiran, Salary: ₹55000.0
*/