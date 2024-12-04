package org.soa.tp5.gestionlocationsmateriels.services;

import org.soa.tp5.gestionlocationsmateriels.Entity.Gerant;
import org.soa.tp5.gestionlocationsmateriels.repositories.GerantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GerantService {

    private final GerantRepository gerantRepository;

    @Autowired
    public GerantService(GerantRepository gerantRepository) {
        this.gerantRepository = gerantRepository;
    }

    public List<Gerant> findAllGerants() {
        return gerantRepository.findAll();
    }


    public Optional<Gerant> findGerantById(Long id) {
        return gerantRepository.findById(id);
    }

    public Gerant saveGerant(Gerant gerant) {
        return gerantRepository.save(gerant);
    }


    public void deleteGerantById(Long id) {
        gerantRepository.deleteById(id);
    }


    public void deleteGerant(Gerant gerant) {
        gerantRepository.delete(gerant);
    }
}
