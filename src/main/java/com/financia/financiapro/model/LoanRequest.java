package com.financia.financiapro.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "loan_requests")
@Getter
@Setter
@NoArgsConstructor
public class LoanRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // L'emprunteur
    @ManyToOne
    @JoinColumn(name = "borrower_id", nullable = false)
    private User borrower;

    // Le prêteur
    @ManyToOne
    @JoinColumn(name = "lender_id", nullable = false)
    private User lender;

    private BigDecimal montant;

    private Double interet;

    private Integer dureeMois;

    // Statut du prêt : PENDING (en attente), ACCEPTED (accepté), REFUSED (refusé) => création énum 'LoanStatus.java'
    @Enumerated(EnumType.STRING)
    private LoanStatus statut;

    // Relation 1-N : un prêt (LoanRequest) peut avoir plusieurs remboursements (Repayment).
    // ça me permet de récupérer tous les remboursements liés à un prêt.
    @OneToMany(mappedBy = "loanRequest", cascade = CascadeType.ALL, orphanRemoval = true)
    private java.util.List<Repayment> repayments = new java.util.ArrayList<>();

}
