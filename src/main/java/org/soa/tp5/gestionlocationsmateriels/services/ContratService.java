package org.soa.tp5.gestionlocationsmateriels.services;

import org.soa.tp5.gestionlocationsmateriels.Entity.ContratLocation;
import org.soa.tp5.gestionlocationsmateriels.repositories.ContratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContratService {

    @Autowired
    private ContratRepository contratRepository;

     public ContratLocation createContrat(ContratLocation contratLocation) {
        return contratRepository.save(contratLocation);
    }

     public List<ContratLocation> getAllContrats() {
        return contratRepository.findAll();
    }

     public Optional<ContratLocation> getContratById(Long id) {
        return contratRepository.findById(id);
    }

     public ContratLocation updateContrat(Long id, ContratLocation updatedContrat) {
        return contratRepository.findById(id).map(contrat -> {
            contrat.setDateContrat(updatedContrat.getDateContrat());
            contrat.setNomClient(updatedContrat.getNomClient());
            contrat.setMontantTotal(updatedContrat.getMontantTotal());
            contrat.setEtat(updatedContrat.getEtat());
            contrat.setDureeLocation(updatedContrat.getDureeLocation());
            contrat.setDepot(updatedContrat.getDepot());
            contrat.setListeMateriels(updatedContrat.getListeMateriels());
            contrat.setGerant(updatedContrat.getGerant());
            return contratRepository.save(contrat);
        }).orElseThrow(() -> new RuntimeException("Contrat introuvable avec ID : " + id));
    }

     public void deleteContratById(Long id) {
        contratRepository.deleteById(id);
    }
}
