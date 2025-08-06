package springq16;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springq16.Post;
import springq16.JsonPlaceholderService;

@RestController
@RequestMapping("/api/posts")
public class JsonPlaceholderController {

    @Autowired
    private JsonPlaceholderService service;

    @GetMapping("/{id}")
    public Post getPost(@PathVariable int id) {
        return service.getPostById(id);
    }

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return service.createPost(post);
    }

    @PutMapping("/{id}")
    public String updatePost(@PathVariable int id, @RequestBody Post post) {
        service.updatePost(id, post);
        return "Post updated successfully!";
    }

    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable int id) {
        service.deletePost(id);
        return "Post deleted successfully!";
    }
}