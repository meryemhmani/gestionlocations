package org.soa.tp5.gestionlocationsmateriels.repositories;

import org.soa.tp5.gestionlocationsmateriels.Entity.Gerant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GerantRepository extends JpaRepository<Gerant, Long> {
    @Override
    List<Gerant> findAll();
    @Override
    void delete(Gerant gerant);
    @Override
    void deleteById(Long id);
    @Override
    Gerant save(Gerant Gerant);

    @Override
   Optional<Gerant> findById(Long id);
}
