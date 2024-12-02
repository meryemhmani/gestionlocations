package org.soa.tp5.gestionlocationsmateriels.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "gerant")
@NoArgsConstructor
@AllArgsConstructor
public class Gerant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false)
    private String adresse;

    @Column(nullable = false, unique = true)
    private String mail;

    @Column(nullable = false)
    private String mdp;

    @OneToMany(mappedBy = "gerant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Depot> depots;

    @OneToMany(mappedBy = "gerant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContratLocation> contratLocations;


}
