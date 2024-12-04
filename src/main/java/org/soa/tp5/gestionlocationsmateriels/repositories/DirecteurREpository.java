package org.soa.tp5.gestionlocationsmateriels.repositories;

import org.soa.tp5.gestionlocationsmateriels.Entity.Directeur;
import org.soa.tp5.gestionlocationsmateriels.Entity.Gerant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DirecteurREpository  extends JpaRepository<Directeur, Long> {
    @Override
    List<Directeur> findAll();
    @Override
    Optional<Directeur> findById(Long id);
    @Override
    void delete(Directeur directeur);
    @Override
    void deleteById(Long id);
    @Override
    Directeur save(Directeur directeur);

}
