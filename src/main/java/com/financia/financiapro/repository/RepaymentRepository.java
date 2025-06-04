package com.financia.financiapro.repository;
import com.financia.financiapro.model.LoanRequest;

import com.financia.financiapro.model.Repayment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepaymentRepository extends JpaRepository<Repayment, Long> {
    List<Repayment> findByLoanRequest(LoanRequest loanRequest);

}
