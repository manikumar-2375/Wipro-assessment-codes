package springmain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springprops.PropertyReader;

@SpringBootApplication
@ComponentScan(basePackages = {"springprops", "springmain"})
public class SpringBootQns2Application implements CommandLineRunner {

    @Autowired
    private PropertyReader reader2;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootQns2Application.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Property Values From Question 2");
        reader2.printValues();
    }
}
