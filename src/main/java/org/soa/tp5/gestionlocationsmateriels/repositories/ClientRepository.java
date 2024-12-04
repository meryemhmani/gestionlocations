package org.soa.tp5.gestionlocationsmateriels.repositories;

import org.soa.tp5.gestionlocationsmateriels.Entity.Categorie;
import org.soa.tp5.gestionlocationsmateriels.Entity.Client;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Override
    void deleteById(Long id);

    @Override
    List<Client> findAll();
    @Override
    Client save (Client client);
    @Override
    Optional<Client> findById(Long id);


}
