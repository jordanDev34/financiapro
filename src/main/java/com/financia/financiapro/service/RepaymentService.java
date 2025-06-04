package com.financia.financiapro.service;

import com.financia.financiapro.model.LoanRequest;
import com.financia.financiapro.model.Repayment;
import com.financia.financiapro.repository.LoanRequestRepository;
import com.financia.financiapro.repository.RepaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RepaymentService {

    private final RepaymentRepository repaymentRepository;
    private final LoanRequestRepository loanRequestRepository;

    public RepaymentService(RepaymentRepository repaymentRepository, LoanRequestRepository loanRequestRepository) {
        this.repaymentRepository = repaymentRepository;
        this.loanRequestRepository = loanRequestRepository;
    }

    // Récupérer tous les remboursements d'une demande de prêt
    public List<Repayment> getByLoanRequest(LoanRequest loanRequest) {
        return repaymentRepository.findByLoanRequest(loanRequest);
    }

    // Ajouter un remboursement
    public Repayment addRepayment(Repayment repayment) {
        return repaymentRepository.save(repayment);
    }

    // Supprimer un remboursement par ID
    public void deleteRepayment(Long id) {
        repaymentRepository.deleteById(id);
    }

    // Récupérer un remboursement par ID
    public Optional<Repayment> getById(Long id) {
        return repaymentRepository.findById(id);
    }
}
