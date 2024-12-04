package org.soa.tp5.gestionlocationsmateriels.repositories;

import org.soa.tp5.gestionlocationsmateriels.Entity.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface reclamationrepository extends JpaRepository<Reclamation, Long> {

    @Override
    List<Reclamation> findAll();

    @Override
    void delete(Reclamation reclamation);

    @Override
    Optional<Reclamation> findById(Long id);

    @Override
    void deleteById(Long id);
}
