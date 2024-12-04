package org.soa.tp5.gestionlocationsmateriels.controllers;

import org.soa.tp5.gestionlocationsmateriels.Entity.Gerant;
import org.soa.tp5.gestionlocationsmateriels.services.GerantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/gerants")
public class gerantcontroller {

    private final GerantService gerantService;

    @Autowired
    public gerantcontroller(GerantService gerantService) {
        this.gerantService = gerantService;
    }

     @GetMapping
    public ResponseEntity<List<Gerant>> getAllGerants() {
        List<Gerant> gerants = gerantService.findAllGerants();
        return new ResponseEntity<>(gerants, HttpStatus.OK);
    }

     @GetMapping("/{id}")
    public ResponseEntity<Gerant> getGerantById(@PathVariable Long id) {
        Optional<Gerant> gerant = gerantService.findGerantById(id);
        return gerant.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

     @PostMapping
    public ResponseEntity<Gerant> createOrUpdateGerant(@RequestBody Gerant gerant) {
        Gerant savedGerant = gerantService.saveGerant(gerant);
        return new ResponseEntity<>(savedGerant, HttpStatus.CREATED);
    }

     @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGerantById(@PathVariable Long id) {
        gerantService.deleteGerantById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

     @DeleteMapping
    public ResponseEntity<Void> deleteGerant(@RequestBody Gerant gerant) {
        gerantService.deleteGerant(gerant);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
