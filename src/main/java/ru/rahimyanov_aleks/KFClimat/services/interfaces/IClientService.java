package ru.rahimyanov_aleks.KFClimat.services.interfaces;

import ru.rahimyanov_aleks.KFClimat.domain.Client;

import java.util.List;

public interface IClientService {
    Client findClientByEmailAndPassword(String email, String password);
    Client createClient(Client client);
    String deleteClient(Long id);
    Client getClient(Long id);
    Client updateClient(Client client, Long id);
    List<Client> getAllClient();
}
