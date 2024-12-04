package org.soa.tp5.gestionlocationsmateriels.repositories;

import org.soa.tp5.gestionlocationsmateriels.Entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Categorie, Long> {
    @Override
      List<Categorie> findAll();
    @Override
    void deleteById(Long id);
    @Override
    Optional<Categorie> findById(Long id);
    @Override
    Categorie save(Categorie category);
    @Override
    void delete(Categorie category);

}
