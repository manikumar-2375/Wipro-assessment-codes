package springq15;

import springq15.Client;
import java.util.List;

public interface ClientService {
    List<Client> getAllClients();
    void saveClient(Client client);
    Client getClientById(Long id);
    void deleteClientById(Long id);
}
