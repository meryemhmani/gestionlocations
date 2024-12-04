package org.soa.tp5.gestionlocationsmateriels.repositories;

import org.soa.tp5.gestionlocationsmateriels.Entity.Depot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepotRepository extends JpaRepository<Depot, Long> {
    @Override
    void delete(Depot depot);
    @Override
    Depot save(Depot depot);
    @Override
    List<Depot> findAll();
    @Override
    Optional<Depot> findById(Long id);
    @Override
    void deleteById(Long id);


}
