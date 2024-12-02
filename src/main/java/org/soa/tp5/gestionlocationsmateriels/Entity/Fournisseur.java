package org.soa.tp5.gestionlocationsmateriels.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "fournisseur")
@NoArgsConstructor
@AllArgsConstructor
public class Fournisseur {

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

    @Column(name = "fax", nullable = false)
    private Long fax;

    @Column(name = "mail", nullable = false, unique = true)
    private String mail;

    @OneToMany(mappedBy = "fournisseur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Materiels> materiels; // Relation avec la liste des matériels
}
