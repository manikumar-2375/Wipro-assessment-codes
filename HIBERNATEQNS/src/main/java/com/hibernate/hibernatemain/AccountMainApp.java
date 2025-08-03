package com.itemcrud.main;

import java.util.List;
import java.util.Scanner;

import com.itemcrud.dao.AccountDAO;
import com.itemcrud.model.Account;

public class AccountMainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AccountDAO dao = new AccountDAO();

        while (true) {
            
            System.out.println("1. Create Account with Transaction");
            System.out.println("2. View All Accounts");
            System.out.println("3. View Account by ID");
            System.out.println("4. Delete Account by ID");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine(); // clear buffer
                    System.out.print("Enter account holder name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter transaction description: ");
                    String desc = sc.nextLine();

                    System.out.print("Enter transaction amount: ");
                    double amount = sc.nextDouble();

                    dao.createAccountWithTransaction(name, desc, amount);
                    break;

                case 2:
                    List<Account> accounts = dao.getAllAccounts();
                    accounts.forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Enter Account ID: ");
                    Account acc = dao.getAccountById(sc.nextInt());
                    System.out.println(acc != null ? acc : "Account not found.");
                    break;

                case 4:
                    System.out.print("Enter Account ID to delete: ");
                    dao.deleteAccount(sc.nextInt());
                    break;

                case 0:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
/*Hibernate : 
1. Create Account with Transaction
2. View All Accounts
3. View Account by ID
4. Delete Account by ID
0. Exit
Choose option: 1
Enter account holder name: mani
Enter transaction description: credit
Enter transaction amount: 7000*/