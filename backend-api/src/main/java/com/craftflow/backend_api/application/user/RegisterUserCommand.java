package com.craftflow.backend_api.application.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * A command for registering a new user.
 *
 * @param email    the email of the user
 * @param password the password of the user
 */
public record RegisterUserCommand(
        /**
         * The email of the user.
         */
        @Email @NotBlank String email,
        /**
         * The password of the user.
         */
        @NotBlank @Size(min = 6) String password
) {}
