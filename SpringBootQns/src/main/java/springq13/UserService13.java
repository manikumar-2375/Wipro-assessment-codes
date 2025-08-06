package springq13;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService13 {

    private final UserRepository13 repo;

    public UserService13(UserRepository13 repo) {
        this.repo = repo;
    }

    public List<User13> findAll() {
        return repo.findAll();
    }

    public User13 findById(Long id) {
        return repo.findById(id)
            .orElseThrow(() -> new UserNotFoundException13(id));
    }

    public User13 save(User13 user) {
        return repo.save(user);
    }

    public User13 update(Long id, User13 incoming) {
        User13 existing = findById(id);
        existing.setName(incoming.getName());
        existing.setAge(incoming.getAge());
        existing.setSalary(incoming.getSalary());
        return repo.save(existing);
    }

    public void delete(Long id) {
        User13 existing = findById(id);
        repo.delete(existing);
    }
}
