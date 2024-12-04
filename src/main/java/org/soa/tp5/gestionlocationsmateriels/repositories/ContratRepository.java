package org.soa.tp5.gestionlocationsmateriels.repositories;

import org.soa.tp5.gestionlocationsmateriels.Entity.ContratLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface ContratRepository extends JpaRepository<ContratLocation,Long> {
    @Override
    void deleteById(Long id);
    @Override
    List<ContratLocation> findAll();
    @Override
    Optional<ContratLocation> findById(Long id);
    @Override
    ContratLocation save(ContratLocation contratLocation);



}
