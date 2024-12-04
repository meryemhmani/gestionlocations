package org.soa.tp5.gestionlocationsmateriels.controllers;

import org.soa.tp5.gestionlocationsmateriels.Entity.Materiels;
import org.soa.tp5.gestionlocationsmateriels.services.MaterielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materiels")
public class MaterielController {

    private final MaterielService materielService;

    @Autowired
    public MaterielController(MaterielService materielService) {
        this.materielService = materielService;
    }

     @PostMapping
    public ResponseEntity<Materiels> createMateriel(@RequestBody Materiels materiel) {
        Materiels createdMateriel = materielService.createMateriel(materiel);
        return new ResponseEntity<>(createdMateriel, HttpStatus.CREATED);
    }

     @GetMapping
    public ResponseEntity<List<Materiels>> getAllMateriels() {
        List<Materiels> materiels = materielService.getAllMateriels();
        return new ResponseEntity<>(materiels, HttpStatus.OK);
    }

     @GetMapping("/{id}")
    public ResponseEntity<Materiels> getMaterielById(@PathVariable Long id) {
        return materielService.getMaterielById(id)
                .map(materiel -> new ResponseEntity<>(materiel, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

     @PutMapping("/{id}")
    public ResponseEntity<Materiels> updateMateriel(@PathVariable Long id, @RequestBody Materiels updatedMateriel) {
        try {
            Materiels materiel = materielService.updateMateriel(id, updatedMateriel);
            return new ResponseEntity<>(materiel, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

     @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaterielById(@PathVariable Long id) {
        materielService.deleteMaterielById(id);
        return ResponseEntity.noContent().build();
    }
}
