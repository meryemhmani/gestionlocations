package org.soa.tp5.gestionlocationsmateriels.services;

import org.soa.tp5.gestionlocationsmateriels.Entity.Depot;
import org.soa.tp5.gestionlocationsmateriels.repositories.DepotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepotService {

    @Autowired
    private DepotRepository depotRepository;

     public Depot createDepot(Depot depot) {
        return depotRepository.save(depot);
    }

     public List<Depot> getAllDepots() {
        return depotRepository.findAll();
    }

     public Optional<Depot> getDepotById(Long id) {
        return depotRepository.findById(id);
    }

     public Depot updateDepot(Long id, Depot updatedDepot) {
        return depotRepository.findById(id).map(depot -> {
            depot.setAdresse(updatedDepot.getAdresse());
            depot.setGerant(updatedDepot.getGerant());
            depot.setDirecteur(updatedDepot.getDirecteur());
            depot.setMateriels(updatedDepot.getMateriels());
            return depotRepository.save(depot);
        }).orElseThrow(() -> new RuntimeException("Dépôt introuvable avec ID : " + id));
    }

     public void deleteDepotById(Long id) {
        depotRepository.deleteById(id);
    }
}
