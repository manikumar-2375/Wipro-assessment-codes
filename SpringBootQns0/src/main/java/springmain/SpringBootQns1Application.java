package springmain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import spring.ClassKLM;

@SpringBootApplication
@ComponentScan(basePackages = {"spring", "springmain"})
public class SpringBootQns1Application implements CommandLineRunner {

    @Autowired
    private ClassKLM klm;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootQns1Application.class, args);
    }

    @Override
    public void run(String... args) {
        klm.invokeDisplay();
    }
}
