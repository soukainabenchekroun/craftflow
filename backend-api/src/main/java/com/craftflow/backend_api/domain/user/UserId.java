package com.craftflow.backend_api.domain.user;

import java.util.UUID;

/**
 * A value object representing a unique identifier for a User.
 *
 * @param value the UUID value of the UserId
 */
public record UserId(UUID value) {
    /**
     * Creates a new UserId with a random UUID.
     *
     * @return a new UserId
     */
    public static UserId newId() {
        return new UserId(UUID.randomUUID());
    }
}
