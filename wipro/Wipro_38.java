package wipro;

import java.io.*;
import java.util.Scanner;

// Serializable Employee class
class Employee_2 implements Serializable {
    private static final long serialVersionUID = 1L;

    int emp_id;
    String emp_name;
    transient double emp_sal; // Will not be serialized

    public Employee_2(int emp_id, String emp_name, double emp_sal) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_sal = emp_sal;
    }

    public void display() {
        System.out.println("Employee ID: " + emp_id);
        System.out.println("Employee Name: " + emp_name);
        System.out.println("Employee Salary: " + emp_sal); // will be 0.0 after deserialization
    }
}

public class Wipro_38 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take input from user
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        sc.nextLine(); // consume newline

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Employee Salary: ");
        double salary = sc.nextDouble();

        // Create employee object
        Employee_2 emp = new Employee_2(id, name, salary);

        // Serialize the object
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employee.ser"))) {
            oos.writeObject(emp);
            System.out.println("\nEmployee object serialized successfully.\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize the object
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employee.ser"))) {
            Employee_2 deserializedEmp = (Employee_2) ois.readObject();
            System.out.println("Deserialized Employee details:");
            deserializedEmp.display(); // emp_sal will be 0.0 due to transient
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        sc.close();
    }
}
/*Enter Employee ID: 201
Enter Employee Name: mani
Enter Employee Salary: 50000

Employee object serialized successfully.

Deserialized Employee details:
Employee ID: 201
Employee Name: mani
Employee Salary: 0.0
*/