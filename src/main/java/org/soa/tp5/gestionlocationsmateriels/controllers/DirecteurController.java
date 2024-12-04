package org.soa.tp5.gestionlocationsmateriels.controllers;

import org.soa.tp5.gestionlocationsmateriels.Entity.Directeur;
import org.soa.tp5.gestionlocationsmateriels.services.DirecteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/directeurs")
public class DirecteurController {

    private final DirecteurService directeurService;

    @Autowired
    public DirecteurController(DirecteurService directeurService) {
        this.directeurService = directeurService;
    }

     @GetMapping
    public ResponseEntity<List<Directeur>> getAllDirecteurs() {
        List<Directeur> directeurs = directeurService.getAllDirecteurs();
        return new ResponseEntity<>(directeurs, HttpStatus.OK);
    }

     @GetMapping("/{id}")
    public ResponseEntity<Directeur> getDirecteurById(@PathVariable Long id) {
        Optional<Directeur> directeur = directeurService.getDirecteurById(id);
        return directeur.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

     @PostMapping
    public ResponseEntity<Directeur> createOrUpdateDirecteur(@RequestBody Directeur directeur) {
        Directeur savedDirecteur = directeurService.saveDirecteur(directeur);
        return new ResponseEntity<>(savedDirecteur, HttpStatus.CREATED);
    }

     @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDirecteur(@PathVariable Long id) {
        directeurService.deleteDirecteurById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
