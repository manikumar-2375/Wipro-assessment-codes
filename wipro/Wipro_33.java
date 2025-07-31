package wipro;

import java.util.Scanner;

public class Wipro_33 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Emp ID: ");
            int id = sc.nextInt();
            sc.nextLine(); 
            System.out.print("Enter Emp Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Designation (Manager/TeamLeader/HR): ");
            String desig = sc.nextLine();

            System.out.print("Enter Basic Salary: ");
            double salary = sc.nextDouble();

            Emp emp = new Emp(id, name, desig, salary);
            emp.printDET();

        } catch (LowSalException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input. " + e);
        }

        sc.close();
    }

    // Custom Exception Class
    static class LowSalException extends Exception {
        public LowSalException(String message) {
            super(message);
        }
    }

    // Employee Class
    static class Emp {
        private int empId;
        private String empName;
        private String designation;
        private double basic;
        private double hra;

        public Emp(int empId, String empName, String designation, double basic) throws LowSalException {
            this.empId = empId;
            this.empName = empName;
            this.designation = designation;

            if (basic < 50000) {
                throw new LowSalException("Basic salary must be at least 50000.");
            }

            this.basic = basic;
            calculateHRA();
        }

        private void calculateHRA() {
            switch (designation.toLowerCase()) {
                case "manager":
                    hra = 0.10 * basic;
                    break;
                case "teamleader":
                    hra = 0.12 * basic;
                    break;
                case "hr":
                    hra = 0.05 * basic;
                    break;
                default:
                    hra = 0.0;
                    break;
            }
        }

        public void printDET() {
            System.out.println("Employee ID     : " + empId);
            System.out.println("Employee Name   : " + empName);
            System.out.println("Designation     : " + designation);
            System.out.println("Basic Salary    : " + basic);
            System.out.println("HRA             : " + hra);
        }
    }
}
/*Enter Emp ID: 32
Enter Emp Name: mani
Enter Designation (Manager/TeamLeader/HR): Manager
Enter Basic Salary: 60000
Employee ID     : 32
Employee Name   : mani
Designation     : Manager
Basic Salary    : 60000.0
HRA             : 6000.0
*/