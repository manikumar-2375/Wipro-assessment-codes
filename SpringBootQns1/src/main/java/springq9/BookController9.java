package springq9;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@RestController
public class BookController9 {

    @RequestMapping("/bookXYZ")
    @ResponseBody
    public List<Book9> getBooks() {
        return Arrays.asList(
                new Book9(101, "Java Tutorials", "Krishna"),
                new Book9(102, "Spring Tutorials", "Mahesh"),
                new Book9(103, "Angular Tutorials", "Shiva")
        );
    }
}
