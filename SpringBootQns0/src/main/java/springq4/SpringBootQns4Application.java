package springq4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"springq4"})
public class SpringBootQns4Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootQns4Application.class, args);
    }
}
// http://localhost:9096/users/101/accounts?type=current&status=active