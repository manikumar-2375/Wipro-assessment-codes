package springq4;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class AccountController {

    @GetMapping("/users/{id}/accounts")
    public Map<String, String> getAccounts(
            @PathVariable String id,
            @RequestParam String type,
            @RequestParam String status) {

        // Just simulate a response for demo
        Map<String, String> result = new HashMap<>();
        result.put("User ID", id);
        result.put("Account Type", type);
        result.put("Status", status);
        result.put("Message", "Account details fetched successfully!");

        return result;
    }
}
