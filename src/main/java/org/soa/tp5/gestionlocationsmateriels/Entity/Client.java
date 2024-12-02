package org.soa.tp5.gestionlocationsmateriels.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Data
@Entity
@Table(name="clinet")
@NoArgsConstructor
@AllArgsConstructor

public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @NotNull
    @Column(name = "client_tx_nom")
    private String nomClient;
    @NotNull
    @Column(name = "client_tx_prennom")
    private String PrenomClient;

    @NotNull
     @Column(name = "client_tx_email")
    private String emailClient;
    @NotNull
    @Column(name = "client_num_tlf")
    private Long tlfClient;
    private Long faxClient;

    @NotNull
    @Column(name = "client_adresse")
    private String AdresseClient;
    @NotNull
    @Column(name = "client_matr_fiscale")
    private String Matricule_fiscale;





}
