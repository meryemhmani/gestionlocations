package org.soa.tp5.gestionlocationsmateriels.repositories;

import org.soa.tp5.gestionlocationsmateriels.Entity.Materiels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MaterielRepository extends JpaRepository<Materiels, Long> {
    @Override
    Materiels save(Materiels materiel);

    @Override
    Optional<Materiels> findById(Long id);

    @Override
    void delete(Materiels materiel);

    @Override
    void deleteById(Long id);

    @Override
    List<Materiels> findAll();
}
