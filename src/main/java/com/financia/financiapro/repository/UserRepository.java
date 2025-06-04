package com.financia.financiapro.repository;

import com.financia.financiapro.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

// findByApiKey =>  authentification par API Key
public interface UserRepository extends JpaRepository<User, Long> {
    User findByApiKey(String apiKey);
}
