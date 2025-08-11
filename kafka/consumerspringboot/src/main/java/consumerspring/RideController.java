package consumerspring;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rides")
public class RideController {

    private final RideRepository repo;
    public RideController(RideRepository repo) { this.repo = repo; }

    @GetMapping
    public List<Ride> getAll() { return repo.findAll(); }

    @GetMapping("/{id}")
    public Ride getOne(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }
}
