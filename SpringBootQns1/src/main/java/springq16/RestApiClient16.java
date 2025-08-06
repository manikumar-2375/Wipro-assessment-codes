package springq16;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class RestApiClient16 {
    private final String BASE_URL = "http://localhost:9101/api/posts";
    private final RestTemplate restTemplate = new RestTemplate();

    public Post getPostById(int id) {
        try {
            return restTemplate.getForObject(BASE_URL + "/" + id, Post.class);
        } catch (HttpClientErrorException.NotFound e) {
            System.out.println("❌ Post with ID " + id + " not found.");
            return null;
        } catch (Exception e) {
            System.out.println("❌ Error while fetching post: " + e.getMessage());
            return null;
        }
    }

    public Post createPost(Post post) {
        try {
            return restTemplate.postForObject(BASE_URL, post, Post.class);
        } catch (Exception e) {
            System.out.println("❌ Error while creating post: " + e.getMessage());
            return null;
        }
    }

    public void updatePost(int id, Post post) {
        try {
            restTemplate.put(BASE_URL + "/" + id, post);
        } catch (Exception e) {
            System.out.println("❌ Error while updating post: " + e.getMessage());
        }
    }

    public void deletePost(int id) {
        try {
            restTemplate.delete(BASE_URL + "/" + id);
        } catch (Exception e) {
            System.out.println("❌ Error while deleting post: " + e.getMessage());
        }
    }
}
