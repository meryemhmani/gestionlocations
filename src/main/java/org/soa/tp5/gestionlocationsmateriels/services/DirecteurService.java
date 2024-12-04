package org.soa.tp5.gestionlocationsmateriels.services;

import org.soa.tp5.gestionlocationsmateriels.Entity.Directeur;
import org.soa.tp5.gestionlocationsmateriels.repositories.DirecteurREpository;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DirecteurService {

    private final DirecteurREpository directeurRepository;

    @Autowired
    public DirecteurService(DirecteurREpository directeurRepository) {
        this.directeurRepository = directeurRepository;
    }

     public List<Directeur> getAllDirecteurs() {
        return directeurRepository.findAll();
    }

     public Optional<Directeur> getDirecteurById(Long id) {
        return directeurRepository.findById(id);
    }

     public Directeur saveDirecteur(Directeur directeur) {
        return directeurRepository.save(directeur);
    }

     public void deleteDirecteurById(Long id) {
        directeurRepository.deleteById(id);
    }
}
