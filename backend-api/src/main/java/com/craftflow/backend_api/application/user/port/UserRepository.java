package com.craftflow.backend_api.application.user.port;

import com.craftflow.backend_api.domain.user.User;
import com.craftflow.backend_api.domain.user.UserId;

import java.util.Optional;

/**
 * A repository for managing users.
 */
public interface UserRepository {
    /**
     * Saves a user.
     *
     * @param user the user to save
     * @return the saved user
     */
    User save(User user);
    /**
     * Finds a user by email.
     *
     * @param email the email of the user to find
     * @return the user if found
     */
    Optional<User> findByEmail(String email);
    /**
     * Finds a user by id.
     *
     * @param id the id of the user to find
     * @return the user if found
     */
    Optional<User> findById(UserId id);
}
