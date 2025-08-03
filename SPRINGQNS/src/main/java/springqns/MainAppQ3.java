package springqns;

import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAppQ3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("     AUTOWIRED ANNOTATION DEMO");
        System.out.println("Options:");
        System.out.println("1. Autowired");
        System.out.println("2. Autowired with Qualifier");
        System.out.print("Select option: ");
        int choice = sc.nextInt();

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_q3.xml");

        Freshman student = (Freshman) context.getBean("student");

        switch (choice) {
            case 1:
                System.out.println("\n Autowired (by type):");
                student.getRoom();
                break;
            case 2:
                System.out.println("\n Autowired with @Qualifier(\"roomB\"):");
                System.out.println(" Please uncomment @Qualifier in Freshman.java to see the effect.");
                student.getRoom();
                break;
            default:
                System.out.println(" Invalid option.");
        }

        sc.close();
    }
}
/*     AUTOWIRED ANNOTATION DEMO
Options:
1. Autowired
2. Autowired with Qualifier
Select option: 1

 Autowired (by type):
Mani Kumar is assigned to: Room 101, Alpha building
*/