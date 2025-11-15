package com.craftflow.backend_api.infrastructure.persistence.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * A JPA repository for managing UserEntity.
 */
public interface UserJpaRepository extends JpaRepository<UserEntity, UUID> {

    /**
     * Finds a user entity by email.
     *
     * @param email the email of the user to find
     * @return the user entity if found
     */
    Optional<UserEntity> findByEmail(String email);
}