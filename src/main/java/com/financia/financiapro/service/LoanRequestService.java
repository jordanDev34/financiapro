package com.financia.financiapro.service;

import com.financia.financiapro.model.LoanRequest;
import com.financia.financiapro.model.User;
import com.financia.financiapro.repository.LoanRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanRequestService {

    private final LoanRequestRepository loanRequestRepository;

    public LoanRequestService(LoanRequestRepository loanRequestRepository) {
        this.loanRequestRepository = loanRequestRepository;
    }

    // J'ajoute une nouvelle demande de prêt
    public LoanRequest addRequest(LoanRequest request) {
        return loanRequestRepository.save(request);
    }

    // Je supprime une demande de prêt par son ID
    public void deleteRequest(Long id) {
        loanRequestRepository.deleteById(id);
    }

    // Je récupère toutes les demandes de prêts d’un emprunteur
    public List<LoanRequest> getByBorrower(User borrower) {
        return loanRequestRepository.findByBorrower(borrower);
    }

    // Je récupère toutes les demandes de prêts d’un prêteur
    public List<LoanRequest> getByLender(User lender) {
        return loanRequestRepository.findByLender(lender);
    }

    // Je trouve une demande de prêt par son ID
    public Optional<LoanRequest> getById(Long id) {
        return loanRequestRepository.findById(id);
    }
}
