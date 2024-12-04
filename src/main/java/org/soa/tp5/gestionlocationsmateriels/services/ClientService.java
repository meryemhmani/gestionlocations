package org.soa.tp5.gestionlocationsmateriels.services;

import org.soa.tp5.gestionlocationsmateriels.Entity.Client;
import org.soa.tp5.gestionlocationsmateriels.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

     public Client createClient(Client client) {
        return clientRepository.save(client);
    }

     public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

     public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

     public Client updateClient(Long id, Client updatedClient) {
        return clientRepository.findById(id).map(client -> {
            client.setNomClient(updatedClient.getNomClient());
            client.setPrenomClient(updatedClient.getPrenomClient());
            client.setEmailClient(updatedClient.getEmailClient());
            client.setTlfClient(updatedClient.getTlfClient());
            client.setFaxClient(updatedClient.getFaxClient());
            client.setAdresseClient(updatedClient.getAdresseClient());
            client.setMatriculeFiscale(updatedClient.getMatriculeFiscale());
            return clientRepository.save(client);
        }).orElseThrow(() -> new RuntimeException("Client introuvable avec ID : " + id));
    }

     public void deleteClientById(Long id) {
        clientRepository.deleteById(id);
    }
}
