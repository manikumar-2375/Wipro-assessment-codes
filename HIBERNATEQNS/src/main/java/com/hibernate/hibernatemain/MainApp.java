package com.itemcrud.main;

import java.util.List;
import java.util.Scanner;

import com.itemcrud.dao.ItemDAO;
import com.itemcrud.model.Item;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ItemDAO dao = new ItemDAO();

        while (true) {
            
            System.out.println("1. Add");
            System.out.println("2. View All");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Get by ID");
           

            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.next();
                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();
                    dao.addItem(new Item(name, price));
                    break;
                case 2:
                    List<Item> items = dao.getAllItems();
                    items.forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("Enter ID to update: ");
                    int id = sc.nextInt();
                    Item existing = dao.getItemById(id);
                    if (existing != null) {
                        System.out.print("Enter new name: ");
                        existing.setName(sc.next());
                        System.out.print("Enter new price: ");
                        existing.setPrice(sc.nextDouble());
                        dao.updateItem(existing);
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter ID to delete: ");
                    dao.deleteItem(sc.nextInt());
                    break;
                case 5:
                    System.out.print("Enter ID: ");
                    Item item = dao.getItemById(sc.nextInt());
                    System.out.println(item != null ? item : "Item not found.");
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
/*1. Add
2. View All
3. Update
4. Delete
5. Get by ID
0. Exit
Choose option: 2
Hibernate: select item0_.id as id1_4_, item0_.name as name2_4_, item0_.price as price3_4_ from item item0_
Item [id=1, name=mani, price=700.0]
Item [id=2, name=manikumar, price=50.0]
1. Add
2. View All
3. Update
4. Delete
5. Get by ID
0. Exit
Choose option: */