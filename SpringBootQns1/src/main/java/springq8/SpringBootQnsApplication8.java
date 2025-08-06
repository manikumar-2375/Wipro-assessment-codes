package springq8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"springmain", "springq8"})
public class SpringBootQnsApplication8 {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootQnsApplication8.class, args);
    }
}
// http://localhost:9100/api8/user