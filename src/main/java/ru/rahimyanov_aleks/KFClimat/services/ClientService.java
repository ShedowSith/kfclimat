package ru.rahimyanov_aleks.KFClimat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rahimyanov_aleks.KFClimat.domain.Client;
import ru.rahimyanov_aleks.KFClimat.repositories.ClientRepository;
import ru.rahimyanov_aleks.KFClimat.services.interfaces.IClientService;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements IClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public Client findClientByEmailAndPassword(String email, String password) {
        Optional<Client> clientOptional = clientRepository.findClientByEmailAndPassword(email, password);
        if (clientOptional.isPresent()){
            return clientOptional.get();
        } else {
            return null;
        }
    }

    @Override
    public Client createClient(Client client) {
        clientRepository.save(client);
        return client;
    }

    @Override
    public String deleteClient(Long id) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        if (clientOptional.isPresent()){
            clientRepository.delete(clientOptional.get());
            return "Client with id:" + id + " was successfully remover";
        } else {
            return "unable to delete client";
        }
    }

    @Override
    public Client getClient(Long id) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        return clientOptional.get();
    }

    @Override
    public Client updateClient(Client client, Long id) {
        return null;
    }

    @Override
    public List<Client> getAllClient() {
        return null;
    }
}
