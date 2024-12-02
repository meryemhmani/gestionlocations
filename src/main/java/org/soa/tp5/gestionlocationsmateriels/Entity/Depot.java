package org.soa.tp5.gestionlocationsmateriels.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "depots")
@NoArgsConstructor
@AllArgsConstructor
public class Depot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "adresse", nullable = false)
    private String adresse;

    @OneToOne
    @JoinColumn(name = "gerant_id", nullable = false)
    private Gerant gerant; // Relation avec la classe Gerant

    @ManyToOne
    @JoinColumn(name = "directeur_id", nullable = false)
    private Directeur directeur; // Relation avec la classe Directeur

    @OneToMany(mappedBy = "depot", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Materiels> materiels; // Relation avec la liste de Materiels
}
