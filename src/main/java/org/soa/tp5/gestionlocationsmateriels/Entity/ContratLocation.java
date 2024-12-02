package org.soa.tp5.gestionlocationsmateriels.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "contrats_location")
@NoArgsConstructor
@AllArgsConstructor
public class ContratLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "date_contrat", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateContrat;

    @Column(name = "nom_client", nullable = false)
    private String nomClient;

    @Column(name = "montant_total", nullable = false)
    private Long montantTotal;

    @Enumerated(EnumType.STRING)
    @Column(name = "etat", nullable = false)
    private Etat etat; // Enum pour les états (PREPARE, SIGNE, ANNULE)

    @Column(name = "duree_location", nullable = false)
    private Long dureeLocation;

    @ManyToOne
    @JoinColumn(name = "code_depot", nullable = false)
    private Depot depot;

    @ManyToMany
    @JoinTable(
            name = "contrat_materiels",
            joinColumns = @JoinColumn(name = "contrat_id"),
            inverseJoinColumns = @JoinColumn(name = "materiel_id")
    )
    private List<Materiels> listeMateriels;
    @ManyToOne
    @JoinColumn(name = "gerant_id")
    private Gerant gerant;
// Liste des matériels liés au contrat
}
