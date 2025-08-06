package springq10;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController10 {

    @GetMapping("/customer-form10")
    public String showForm(Model model) {
        model.addAttribute("customerForm10", new CustomerForm10());
        return "index10";
    }

    @PostMapping("/customer-form10")
    public String submitForm(@Valid @ModelAttribute("customerForm10") CustomerForm10 form,
                             BindingResult br,
                             Model model) {
        if (br.hasErrors()) {
            return "index10";
        }
        model.addAttribute("successMessage", "Customer saved successfully!");
        return "index10";
    }
}
