package springq16;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import springq16.Post;

@Service
public class JsonPlaceholderService {

    private final String BASE_URL = "https://jsonplaceholder.typicode.com/posts";
    private final RestTemplate restTemplate = new RestTemplate();

    // GET by ID
    public Post getPostById(int id) {
        return restTemplate.getForObject(BASE_URL + "/" + id, Post.class);
    }

    // POST (Create)
    public Post createPost(Post post) {
        return restTemplate.postForObject(BASE_URL, post, Post.class);
    }

    // PUT (Update)
    public void updatePost(int id, Post post) {
        restTemplate.put(BASE_URL + "/" + id, post);
    }

    // DELETE
    public void deletePost(int id) {
        restTemplate.delete(BASE_URL + "/" + id);
    }
}