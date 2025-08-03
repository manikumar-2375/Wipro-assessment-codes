package com.itemcrud.main;

import com.itemcrud.dao.AuthorDAO;
import java.util.Scanner;

public class AuthorMainApp {
    public static void main(String[] args) {
        AuthorDAO dao = new AuthorDAO();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Add Author with Books");
            System.out.println("2. View All Authors");
            System.out.println("3. Delete Author by ID");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    dao.addAuthorWithBooks();
                    break;

                case 2:
                    dao.viewAuthors();
                    break;

                case 3:
                    System.out.print("Enter author ID to delete: ");
                    int id = sc.nextInt();
                    dao.deleteAuthorById(id);
                    break;

                case 0:
                    System.out.println("Exited.");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 0);

        sc.close();
    }
}
/*1. Add Author with Books
2. View All Authors
3. Delete Author by ID
0. Exit
Choose option: 1
Enter author name: mani
How many books? 1
Enter book title 1: hero
Hibernate: insert into Author (name) values (?)
Author and books saved.
1. Add Author with Books
2. View All Authors
3. Delete Author by ID
0. Exit*/