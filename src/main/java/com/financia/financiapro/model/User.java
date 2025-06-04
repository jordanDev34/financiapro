package com.financia.financiapro.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String prenom;
    private String nom;
    private String email;

    @Column(unique = true)
    private String apiKey;

    // Un User peut avoir plusieurs BudgetItem
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private java.util.List<BudgetItem> budgetItems = new java.util.ArrayList<>();

    // Liste des prêts que l’utilisateur a demandé en tant qu’emprunteur
    @OneToMany(mappedBy = "borrower")
    private List<LoanRequest> emprunts;

    // Liste des prêts que l’utilisateur a accordé en tant que prêteur
    @OneToMany(mappedBy = "lender")
    private List<LoanRequest> prets;

}
