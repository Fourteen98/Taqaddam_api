package com.ummuammar.taqaddam.api.v1.account.repositories;

import com.ummuammar.taqaddam.api.v1.account.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
}
