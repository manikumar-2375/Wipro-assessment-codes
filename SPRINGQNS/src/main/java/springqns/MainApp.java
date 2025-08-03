package springqns;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("springqns")
public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainApp.class);

        PropertyLoader loader = context.getBean(PropertyLoader.class);

        System.out.println("URL      : " + loader.getUrl());
        System.out.println("Username : " + loader.getUsername());
        System.out.println("Password : " + loader.getPassword());

        context.close();
    }
}
/*URL      : http://gmail.com
Username : manikumar
Password : yoyo123
*/