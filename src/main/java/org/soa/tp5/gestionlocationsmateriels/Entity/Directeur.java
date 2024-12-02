package org.soa.tp5.gestionlocationsmateriels.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "directeur")
@NoArgsConstructor
@AllArgsConstructor
public class Directeur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "prenom", nullable = false)
    private String prenom;

    @Column(name = "adresse", nullable = false)
    private String adresse;

    @Column(name = "telephone", nullable = false)
    private Long telephone;

    @OneToMany(mappedBy = "directeur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Depot> depots; // Relation avec une liste de dépôts
}
