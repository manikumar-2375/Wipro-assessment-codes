package springq15;

import springq15.Client;
import springq15.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepo;

    public List<Client> getAllClients() {
        return clientRepo.findAll();
    }

    public void saveClient(Client client) {
        clientRepo.save(client);
    }

    public Client getClientById(Long id) {
        return clientRepo.findById(id).orElse(null);
    }

    public void deleteClientById(Long id) {
        clientRepo.deleteById(id);
    }
}
