package springqns;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class MainAppQ4 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContextQ4.xml");

        AccountQ4 account = (AccountQ4) context.getBean("accountQ4");

        Scanner sc = new Scanner(System.in);

        System.out.println("Default account loaded from properties:");
        account.display();

        System.out.println("Do you want to override the values? (yes/no)");
        String choice = sc.nextLine();

        if (choice.equalsIgnoreCase("yes")) {
            System.out.print("Enter Account Number: ");
            account.setNumber(Integer.parseInt(sc.nextLine()));

            System.out.print("Enter Account Holder Name: ");
            account.setHolder(sc.nextLine());

            System.out.print("Enter Account Balance: ");
            account.setBalance(Double.parseDouble(sc.nextLine()));

            System.out.print("Enter Account Type: ");
            account.setType(sc.nextLine());
        }

        System.out.println("Final Account Details:");
        account.display();
    }
}
/*Default account loaded from properties:
Account Number: 123456
Account Holder: Mani Kumar
Account Balance: 87500.5
Account Type: Savings
Do you want to override the values? (yes/no)
yes
Enter Account Number: 7896
Enter Account Holder Name: kumar
Enter Account Balance: 4000
Enter Account Type: savings
Final Account Details:
Account Number: 7896
Account Holder: kumar
Account Balance: 4000.0
Account Type: savings*/