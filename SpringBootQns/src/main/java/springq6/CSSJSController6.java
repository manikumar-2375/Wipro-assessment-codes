package springq6;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CSSJSController6 {

    @GetMapping("/")
    public String loadHomePage6() {
        return "index6";  // index6.html from templates
    }
}
