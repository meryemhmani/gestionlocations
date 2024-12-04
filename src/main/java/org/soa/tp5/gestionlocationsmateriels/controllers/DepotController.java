package org.soa.tp5.gestionlocationsmateriels.controllers;

import org.soa.tp5.gestionlocationsmateriels.Entity.Depot;
import org.soa.tp5.gestionlocationsmateriels.services.DepotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/depots")
public class DepotController {

    private final DepotService depotService;

    @Autowired
    public DepotController(DepotService depotService) {
        this.depotService = depotService;
    }

     @PostMapping
    public ResponseEntity<Depot> createDepot(@RequestBody Depot depot) {
        Depot createdDepot = depotService.createDepot(depot);
        return new ResponseEntity<>(createdDepot, HttpStatus.CREATED);
    }

     @GetMapping
    public ResponseEntity<List<Depot>> getAllDepots() {
        List<Depot> depots = depotService.getAllDepots();
        return new ResponseEntity<>(depots, HttpStatus.OK);
    }

     @GetMapping("/{id}")
    public ResponseEntity<Depot> getDepotById(@PathVariable Long id) {
        return depotService.getDepotById(id)
                .map(depot -> new ResponseEntity<>(depot, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

     @PutMapping("/{id}")
    public ResponseEntity<Depot> updateDepot(@PathVariable Long id, @RequestBody Depot updatedDepot) {
        try {
            Depot depot = depotService.updateDepot(id, updatedDepot);
            return new ResponseEntity<>(depot, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
     @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepotById(@PathVariable Long id) {
        depotService.deleteDepotById(id);
        return ResponseEntity.noContent().build();
    }

}
