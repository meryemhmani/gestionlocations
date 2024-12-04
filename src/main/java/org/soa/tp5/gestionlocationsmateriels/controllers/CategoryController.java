package org.soa.tp5.gestionlocationsmateriels.controllers;

import org.soa.tp5.gestionlocationsmateriels.Entity.Categorie;
import org.soa.tp5.gestionlocationsmateriels.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategorieService categorieService;

    @Autowired
    public CategoryController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    // Sauvegarder une catégorie
    @PostMapping
    public ResponseEntity<Categorie> saveCategory(@RequestBody Categorie categorie) {
        Categorie savedCategorie = categorieService.sauver(categorie);
        return new ResponseEntity<>(savedCategorie, HttpStatus.CREATED);
    }

    // Sauvegarder plusieurs catégories
    @PostMapping("/sauver")
    public ResponseEntity<Void> saveAllCategories(@RequestBody List<Categorie> categories) {
        categorieService.sauverAll(categories);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Récupérer une catégorie par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Categorie> getCategoryById(@PathVariable Long id) {
        Categorie categorie = categorieService.chercherById(id);
        if (categorie != null) {
            return new ResponseEntity<>(categorie, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Récupérer toutes les catégories
    @GetMapping
    public ResponseEntity<List<Categorie>> getAllCategories() {
        List<Categorie> categories = categorieService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    // Mettre à jour une catégorie
    @PutMapping("/{id}/update")
    public ResponseEntity<Categorie> updateCategory(@PathVariable Long id, @RequestBody Categorie categorie) {
        Categorie updatedCategorie = categorieService.update(id, categorie);
        if (updatedCategorie != null) {
            return new ResponseEntity<>(updatedCategorie, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Supprimer une catégorie par son ID
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categorieService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
