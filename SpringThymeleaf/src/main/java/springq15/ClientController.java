package springq15;

import springq15.Client;
import springq15.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listClients", clientService.getAllClients());
        return "index";
    }

    @GetMapping("/showNewClientForm")
    public String showNewClientForm(Model model) {
        model.addAttribute("client", new Client());
        return "new_client";
    }

    @PostMapping("/saveClient")
    public String saveClient(@ModelAttribute("client") Client client) {
        clientService.saveClient(client);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable Long id, Model model) {
        model.addAttribute("client", clientService.getClientById(id));
        return "update_client";
    }

    @GetMapping("/deleteClient/{id}")
    public String deleteClient(@PathVariable Long id) {
        clientService.deleteClientById(id);
        return "redirect:/";
    }
}
