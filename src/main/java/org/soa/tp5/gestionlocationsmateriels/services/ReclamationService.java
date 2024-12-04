package org.soa.tp5.gestionlocationsmateriels.services;

import org.soa.tp5.gestionlocationsmateriels.Entity.Reclamation;
 import org.soa.tp5.gestionlocationsmateriels.repositories.reclamationrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReclamationService {

    @Autowired
    private reclamationrepository reclamationRepository;

     public Reclamation createReclamation(Reclamation reclamation) {
        return reclamationRepository.save(reclamation);
    }

     public List<Reclamation> getAllReclamations() {
        return reclamationRepository.findAll();
    }

     public Optional<Reclamation> getReclamationById(Long id) {
        return reclamationRepository.findById(id);
    }

     public Reclamation updateReclamation(Long id, Reclamation updatedReclamation) {
        return reclamationRepository.findById(id).map(reclamation -> {
            reclamation.setDescription(updatedReclamation.getDescription());
            reclamation.setDate(updatedReclamation.getDate());
            reclamation.setClient(updatedReclamation.getClient());
            return reclamationRepository.save(reclamation);
        }).orElseThrow(() -> new RuntimeException("Réclamation introuvable avec ID : " + id));
    }

     public void deleteReclamationById(Long id) {
        reclamationRepository.deleteById(id);
    }
}
