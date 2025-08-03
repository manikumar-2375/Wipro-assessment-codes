package springqns;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Q5_MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Q5_AppConfig.class);
        Q5_Item item = context.getBean(Q5_Item.class);
        Q5_Category category = item.getCategory();

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Item ID: ");
        item.setId(sc.nextInt());

        System.out.print("Enter Item Name: ");
        sc.nextLine(); // consume newline
        item.setName(sc.nextLine());

        System.out.print("Enter Item Price: ");
        item.setPrice(sc.nextDouble());

        System.out.print("Enter Category ID: ");
        category.setCategoryId(sc.nextInt());

        System.out.print("Enter Category Name: ");
        sc.nextLine(); // consume newline
        category.setCategoryName(sc.nextLine());

        System.out.println("\n Item Details:");
        item.display();
    }
}
/*Enter Item ID: 102
Enter Item Name: bag
Enter Item Price: 230
Enter Category ID: 201
Enter Category Name: bag1

 Item Details:
Item ID: 102
Item Name: bag
Item Price: 230.0
Category ID: 201
Category Name: bag1
*/