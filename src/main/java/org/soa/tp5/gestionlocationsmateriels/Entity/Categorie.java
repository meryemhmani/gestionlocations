package org.soa.tp5.gestionlocationsmateriels.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Data
@Entity
@Table(name="categorie")
@NoArgsConstructor
@AllArgsConstructor


public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "designation_categorie")
    private String designation;

}
