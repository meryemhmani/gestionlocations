package org.soa.tp5.gestionlocationsmateriels.controllers;

import org.soa.tp5.gestionlocationsmateriels.Entity.ContratLocation;
import org.soa.tp5.gestionlocationsmateriels.services.ContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contrats")
public class ContratController {

    private final ContratService contratService;

    @Autowired
    public ContratController(ContratService contratService) {
        this.contratService = contratService;
    }

     @PostMapping
    public ResponseEntity<ContratLocation> createContrat(@RequestBody ContratLocation contratLocation) {
        ContratLocation createdContrat = contratService.createContrat(contratLocation);
        return new ResponseEntity<>(createdContrat, HttpStatus.CREATED);
    }

     @GetMapping
    public ResponseEntity<List<ContratLocation>> getAllContrats() {
        List<ContratLocation> contrats = contratService.getAllContrats();
        return new ResponseEntity<>(contrats, HttpStatus.OK);
    }

     @GetMapping("/{id}")
    public ResponseEntity<ContratLocation> getContratById(@PathVariable Long id) {
        return contratService.getContratById(id)
                .map(contrat -> new ResponseEntity<>(contrat, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

     @PutMapping("/{id}")
    public ResponseEntity<ContratLocation> updateContrat(@PathVariable Long id, @RequestBody ContratLocation updatedContrat) {
        try {
            ContratLocation contrat = contratService.updateContrat(id, updatedContrat);
            return new ResponseEntity<>(contrat, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

     @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContratById(@PathVariable Long id) {
        contratService.deleteContratById(id);
        return ResponseEntity.noContent().build();
    }
}
