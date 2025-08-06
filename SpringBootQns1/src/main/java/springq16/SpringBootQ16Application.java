package springq16;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringBootQ16Application implements CommandLineRunner {

    @Autowired
    private RestApiClient16 service;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootQ16Application.class, args);
    }

    @Override
    public void run(String... args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== REST API Client ===");
            System.out.println("1. GET Post");
            System.out.println("2. CREATE Post");
            System.out.println("3. UPDATE Post");
            System.out.println("4. DELETE Post");
            System.out.println("5. EXIT");
            System.out.print("Choose Option: ");

            int option = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (option) {
                case 1 -> {
                    System.out.print("Enter Post ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    Post post = service.getPostById(id);
                    if (post != null) {
                        System.out.println("📄 Post Title: " + post.getTitle());
                        System.out.println("📝 Post Body: " + post.getBody());
                    }
                }
                case 2 -> {
                    Post newPost = new Post();
                    System.out.print("Enter User ID: ");
                    newPost.setUserId(sc.nextInt());
                    sc.nextLine();
                    System.out.print("Enter Title: ");
                    newPost.setTitle(sc.nextLine());
                    System.out.print("Enter Body: ");
                    newPost.setBody(sc.nextLine());
                    Post created = service.createPost(newPost);
                    if (created != null) {
                        System.out.println("✅ Created Post with ID: " + created.getId());
                    }
                }
                case 3 -> {
                    Post updatePost = new Post();
                    System.out.print("Enter Post ID to Update: ");
                    int updateId = sc.nextInt();
                    System.out.print("Enter User ID: ");
                    updatePost.setUserId(sc.nextInt());
                    sc.nextLine();
                    System.out.print("Enter New Title: ");
                    updatePost.setTitle(sc.nextLine());
                    System.out.print("Enter New Body: ");
                    updatePost.setBody(sc.nextLine());
                    service.updatePost(updateId, updatePost);
                    System.out.println("✅ Post Updated (check response on API site - dummy update).");
                }
                case 4 -> {
                    System.out.print("Enter Post ID to Delete: ");
                    int deleteId = sc.nextInt();
                    service.deletePost(deleteId);
                    System.out.println("🗑️ Post Deleted (fake delete on API).");
                }
                case 5 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("❗ Invalid Option");
            }
        }
    }
}
