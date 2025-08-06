package springq6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"springq6", "springq6"})
public class SpringBootQ6Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootQ6Application.class, args);
    }
}
