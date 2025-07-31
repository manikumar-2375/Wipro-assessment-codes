package wipro;

import java.util.*;

import java.util.Scanner;

abstract class Bank {
 String accNo;
 String custName;
 int custGender; 
 String custJob;
 double curBal;

 // Constructor
 public Bank(String accNo, String custName, int custGender, String custJob, double curBal) {
     this.accNo = accNo;
     this.custName = custName;
     this.custGender = custGender;
     this.custJob = custJob;
     this.curBal = curBal;
 }

 public abstract double calcBalance();

 @Override
 public String toString() {
     return "Account No: " + accNo +
            "\nName: " + custName +
            "\nGender: " + (custGender == 1 ? "Male" : "Female") +
            "\nJob: " + custJob +
            "\nCurrent Balance: RM " + curBal;
 }
}

class Saving extends Bank {
 double savRate;

 public Saving(String accNo, String custName, int custGender, String custJob, double curBal, double savRate) {
     super(accNo, custName, custGender, custJob, curBal);
     this.savRate = savRate;
 }

 @Override
 public double calcBalance() {
     return curBal + (savRate * curBal);
 }
}

class Current extends Bank {
 boolean fixedDep;
 double curRate;

 public Current(String accNo, String custName, int custGender, String custJob, double curBal, double curRate, boolean fixedDep) {
     super(accNo, custName, custGender, custJob, curBal);
     this.curRate = curRate;
     this.fixedDep = fixedDep;
 }

 @Override
 public double calcBalance() {
     double balance = curBal + (curRate * curBal);
     if (fixedDep) {
         balance -= 150; 
     }
     return balance;
 }
}

public class Bank_18 {

	public static void main(String[] args) {
		
		 Scanner scanner = new Scanner(System.in);
	        ArrayList<Bank> customers = new ArrayList<>();

	        customers.add(new Saving("S001", "Ravi", 1, "Engineer", 5000, 0.05));
	        customers.add(new Saving("S002", "Anu", 2, "Doctor", 8000, 0.06));
	        customers.add(new Current("C001", "Kiran", 1, "Manager", 10000, 0.04, true));
	        customers.add(new Current("C002", "Divya", 2, "Lawyer", 7000, 0.03, false));
	        customers.add(new Current("C003", "Mohan", 1, "Pilot", 9000, 0.05, true));

	        System.out.println("----- All Account Balances -----");
	        for (Bank b : customers) {
	            System.out.println(b.toString());
	            System.out.printf("Final Balance: RM %.2f\n", b.calcBalance());
	            System.out.println("------------------------------");
	        }

	        System.out.print("\nEnter account number to search: ");
	        String searchAcc = scanner.nextLine();
	        boolean found = false;
	        for (Bank b : customers) {
	            if (b.accNo.equalsIgnoreCase(searchAcc)) {
	                System.out.println("Customer Found:");
	                System.out.println(b.toString());
	                System.out.printf("Final Balance: RM %.2f\n", b.calcBalance());
	                found = true;
	                break;
	            }
	        }
	        if (!found) {
	            System.out.println("Account not found.");
	        }

	        int currentCount = 0;
	        double currentTotalBalance = 0.0;
	        for (Bank b : customers) {
	            if (b instanceof Current) {
	                currentCount++;
	                currentTotalBalance += b.calcBalance();
	            }
	        }

	        System.out.println("\nTotal Current Account Holders: " + currentCount);
	        System.out.printf("Total Balance in Current Accounts: RM %.2f\n", currentTotalBalance);

	        scanner.close();

	}

}
/*----- All Account Balances -----
Account No: S001
Name: Ravi
Gender: Male
Job: Engineer
Current Balance: RM 5000.0
Final Balance: RM 5250.00
------------------------------
Account No: S002
Name: Anu
Gender: Female
Job: Doctor
Current Balance: RM 8000.0
Final Balance: RM 8480.00
------------------------------
Account No: C001
Name: Kiran
Gender: Male
Job: Manager
Current Balance: RM 10000.0
Final Balance: RM 10250.00
------------------------------
Account No: C002
Name: Divya
Gender: Female
Job: Lawyer
Current Balance: RM 7000.0
Final Balance: RM 7210.00
------------------------------
Account No: C003
Name: Mohan
Gender: Male
Job: Pilot
Current Balance: RM 9000.0
Final Balance: RM 9300.00
------------------------------

Enter account number to search: c003
Customer Found:
Account No: C003
Name: Mohan
Gender: Male
Job: Pilot
Current Balance: RM 9000.0
Final Balance: RM 9300.00

Total Current Account Holders: 3
Total Balance in Current Accounts: RM 26760.00
*/