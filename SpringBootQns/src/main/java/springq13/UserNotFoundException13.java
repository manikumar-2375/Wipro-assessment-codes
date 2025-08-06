package springq13;

public class UserNotFoundException13 extends RuntimeException {
    public UserNotFoundException13(Long id) {
        super("User with id " + id + " not found");
    }
}
