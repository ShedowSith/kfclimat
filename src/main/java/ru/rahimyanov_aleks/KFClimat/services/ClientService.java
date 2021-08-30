package ru.rahimyanov_aleks.KFClimat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rahimyanov_aleks.KFClimat.domain.Client;
import ru.rahimyanov_aleks.KFClimat.exceptions.CustomEmptyDataException;
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
    @Transactional
    public Client findClientByEmailAndPassword(String email, String password) {
        Optional<Client> clientOptional = clientRepository.findClientByEmailAndPassword(email, password);
        if (clientOptional.isPresent()){
            return clientOptional.get();
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public Client createClient(Client client) {
        clientRepository.save(client);
        return client;
    }

    @Override
    @Transactional
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
    @Transactional
    public Client getClient(Long id) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        return clientOptional.get();
    }

    @Override
    @Transactional
    public Client updateClient(Client client, Long id) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        if (clientOptional.isPresent()){
            Client target = clientOptional.get();
            target.setName(client.getName());
            target.setSurname(client.getSurname());
            target.setPatronymic(client.getPatronymic());
            target.setPassword(client.getPassword());
            target.setEmail(client.getEmail());
            clientRepository.save(target);
            return target;
        } else {
            throw new CustomEmptyDataException("unable to update client");
        }

    }

    @Override
    @Transactional
    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }
}
