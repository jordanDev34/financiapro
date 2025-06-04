package com.financia.financiapro.service;

import com.financia.financiapro.model.User;
import com.financia.financiapro.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Logique métier (crud) utilisé par le controller
@Service
public class UserService {

    private final UserRepository userRepository;

    // J'injecte le repository par le constructeur
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // CRUD

    // Je récupère tous les utilisateurs en base
    public List<User> findAll() {
        return userRepository.findAll();
    }

    // Je récupère un user par son ID
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    // J'enregistre un nouvel utilisateur
    public User save(User user) {
        return userRepository.save(user);
    }

    // Je supprime un user par son ID
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
