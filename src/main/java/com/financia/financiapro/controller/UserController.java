package com.financia.financiapro.controller;

import com.financia.financiapro.model.User;
import com.financia.financiapro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Récupérer tous les utilisateurs
    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll(); // ✅
    }

    // Récupérer un utilisateur par son ID
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.findById(id); // ✅
    }

    // Créer un nouvel utilisateur
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.save(user); // ✅
    }

    // Supprimer un utilisateur par son ID
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteById(id); // ✅
    }
}
