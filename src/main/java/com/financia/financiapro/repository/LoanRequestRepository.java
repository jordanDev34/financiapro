package com.financia.financiapro.repository;

import com.financia.financiapro.model.LoanRequest;
import com.financia.financiapro.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LoanRequestRepository extends JpaRepository<LoanRequest, Long> {

    // Je trouve les prêts où l'utilisateur est l'emprunteur
    List<LoanRequest> findByBorrower(User borrower);

    // Et ici, je trouve les prêts où l'utilisateur est le prêteur
    List<LoanRequest> findByLender(User lender);
}
