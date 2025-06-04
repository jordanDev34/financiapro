package com.financia.financiapro.service;

import com.financia.financiapro.model.BudgetItem;
import com.financia.financiapro.model.User;
import com.financia.financiapro.repository.BudgetItemRepository;
import com.financia.financiapro.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BudgetItemService {

    private final BudgetItemRepository budgetItemRepository;
    private final UserRepository userRepository;

    public BudgetItemService(BudgetItemRepository budgetItemRepository, UserRepository userRepository) {
        this.budgetItemRepository = budgetItemRepository;
        this.userRepository = userRepository;
    }

    // Je récupère tous les BudgetItems liés à un utilisateur
    public List<BudgetItem> getItemsByUserId(Long userId) {
        return budgetItemRepository.findByUserId(userId);
    }

    // J'ajoute un BudgetItem pour un utilisateur donné
    public BudgetItem addItem(Long userId, BudgetItem item) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            item.setUser(user.get());
            return budgetItemRepository.save(item);
        } else {
            throw new IllegalArgumentException("Utilisateur non trouvé avec l'id : " + userId);
        }
    }

    // Je supprime un BudgetItem par son ID
    public void deleteItem(Long itemId) {
        budgetItemRepository.deleteById(itemId);
    }
}
