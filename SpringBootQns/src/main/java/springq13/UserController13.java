package springq13;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api13/user")
public class UserController13 {

    private final UserService13 service;

    public UserController13(UserService13 service) {
        this.service = service;
    }

    // Retrieve all users
    @GetMapping
    public List<User13> getAll() {
        return service.findAll();
    }

    // Retrieve single user
    @GetMapping("/{id}")
    public User13 getById(@PathVariable Long id) {
        return service.findById(id);
    }

    // Create
    @PostMapping
    public User13 create(@RequestBody User13 user) {
        return service.save(user);
    }

    // Update
    @PutMapping("/{id}")
    public User13 update(@PathVariable Long id, @RequestBody User13 user) {
        return service.update(id, user);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Exception handler for not found
    @ExceptionHandler(UserNotFoundException13.class)
    public ResponseEntity<ErrorResponse13> handleNotFound(UserNotFoundException13 ex) {
        return ResponseEntity.status(404)
                .body(new ErrorResponse13(ex.getMessage()));
    }
}
