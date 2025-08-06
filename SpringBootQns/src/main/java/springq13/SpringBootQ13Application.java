package springq13;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootQ13Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootQ13Application.class, args);
    }
}
// http://localhost:9100/api13/user

// http://localhost:9100/swagger-ui

// http://localhost:9100/actuator
// http://localhost:9100/actuator/beans/health/info