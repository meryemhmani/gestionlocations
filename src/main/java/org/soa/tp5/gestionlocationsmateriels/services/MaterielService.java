package org.soa.tp5.gestionlocationsmateriels.services;

import org.soa.tp5.gestionlocationsmateriels.Entity.Materiels;
import org.soa.tp5.gestionlocationsmateriels.repositories.MaterielRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterielService {

    @Autowired
    private MaterielRepository materielRepository;

     public Materiels createMateriel(Materiels materiel) {
        return materielRepository.save(materiel);
    }

     public List<Materiels> getAllMateriels() {
        return materielRepository.findAll();
    }

     public Optional<Materiels> getMaterielById(Long id) {
        return materielRepository.findById(id);
    }

     public Materiels updateMateriel(Long id, Materiels updatedMateriel) {
        return materielRepository.findById(id).map(materiel -> {
            materiel.setDesignation(updatedMateriel.getDesignation());
            materiel.setEtat(updatedMateriel.getEtat());
            materiel.setCapacite(updatedMateriel.getCapacite());
            materiel.setPrixLocation(updatedMateriel.getPrixLocation());
            materiel.setDepot(updatedMateriel.getDepot());
            materiel.setFournisseur(updatedMateriel.getFournisseur());
            materiel.setCategorie(updatedMateriel.getCategorie());
            materiel.setContratLocation(updatedMateriel.getContratLocation());
            return materielRepository.save(materiel);
        }).orElseThrow(() -> new RuntimeException("Matériel introuvable avec ID : " + id));
    }

     public void deleteMaterielById(Long id) {
        materielRepository.deleteById(id);
    }
}
