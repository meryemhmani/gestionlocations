package org.soa.tp5.gestionlocationsmateriels.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "materiels")
@NoArgsConstructor
@AllArgsConstructor
public class Materiels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "designation", nullable = false)
    private String designation;

    @Enumerated(EnumType.STRING)
    @Column(name = "etat", nullable = false)
    private Etat etat; // Enum pour gérer les états (NEUF, OCCASION, USÉ)

    @Column(name = "capacite", nullable = false)
    private Long capacite;

    @Column(name = "prix_location", nullable = false)
    private Long prixLocation;

    @ManyToOne
    @JoinColumn(name = "id_depot", nullable = false)
    private Depot depot;

    @ManyToOne
    @JoinColumn(name = "id_fournisseur", nullable = false)
    private Fournisseur fournisseur;

    @ManyToOne
    @JoinColumn(name = "id_categorie", nullable = false)
    private Categorie categorie;

    @ManyToOne
    @JoinColumn(name = "id_contrat_location", nullable = true)
    private ContratLocation contratLocation; // Relation avec la table ContratLocation
}
