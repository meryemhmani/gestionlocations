package org.soa.tp5.gestionlocationsmateriels.services;

import org.soa.tp5.gestionlocationsmateriels.Entity.Categorie;
import org.soa.tp5.gestionlocationsmateriels.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieService {

    private final CategoryRepository categorieRepository;

    @Autowired
    public CategorieService(CategoryRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    // Sauver une catégorie
    public Categorie sauver(Categorie c) {
        return categorieRepository.save(c);
    }

    // Sauver plusieurs catégories
    public void sauverAll(List<Categorie> listc) {
        categorieRepository.saveAll(listc);
    }

    // Supprimer une catégorie par son ID
    public void delete(Long cId) {
        categorieRepository.deleteById(cId);
    }

    // Récupérer une catégorie par son ID
    public Categorie chercherById(Long cId) {
        Optional<Categorie> optionalCategorie = categorieRepository.findById(cId);
        return optionalCategorie.orElse(null);
    }

    // Mettre à jour une catégorie
    public Categorie update(Long cId, Categorie c) {
        Optional<Categorie> existingCategorie = categorieRepository.findById(cId);
        if (existingCategorie.isPresent()) {
            Categorie categorieToUpdate = existingCategorie.get();
            categorieToUpdate.setDesignation(c.getDesignation());
            return categorieRepository.save(categorieToUpdate);
        }
        return null;
    }

    // Supprimer une catégorie par un objet Categorie
    public void delete(Categorie c) {
        categorieRepository.delete(c);
    }

    // Récupérer toutes les catégories
    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }
}
