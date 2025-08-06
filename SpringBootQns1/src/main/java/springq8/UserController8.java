package springq8;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api8")
public class UserController8 {

    @PostMapping("/user")
    public String createUser(@RequestBody User8 user) {
        return "Received user: " + user;
    }
}
