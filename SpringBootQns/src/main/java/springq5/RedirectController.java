package springq5;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {

    @GetMapping("/example/test")
    public String redirectToTest2() {
        // This triggers a 302 redirect
        return "redirect:/example/test2";
    }

    @GetMapping("/example/test2")
    public String test2() {
        System.out.println("Redirected to /example/test2");
        return "redirect-success";  // refers to redirect-success.html in templates
    }
}
