package com.financia.financiapro.repository;

import com.financia.financiapro.model.BudgetItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BudgetItemRepository extends JpaRepository<BudgetItem, Long> {
    List<BudgetItem> findByUserId(Long userId);

}
