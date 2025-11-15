package com.craftflow.backend_api.application.user;

import java.util.UUID;

/**
 * A result for registering a new user.
 *
 * @param id the id of the user
 * @param email the email of the user
 */     
public record RegisterUserResult(
        /**
         * The id of the user.
         */
        UUID id,
        /**
         * The email of the user.
         */
        String email
) {}
