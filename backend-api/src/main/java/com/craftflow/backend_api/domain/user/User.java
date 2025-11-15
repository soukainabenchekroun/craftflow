package com.craftflow.backend_api.domain.user;

import java.util.Set;

/**
 * A domain entity representing a User.
 */
public class User {

    /**
     * The unique identifier of the User.
     */
    private final UserId id;
    /**
     * The email of the User.
     */
    private final String email;
    /**
     * The hash of the password of the User.
     */
    private final String passwordHash;
    /**
     * The roles of the User.
     */
    private final Set<Role> roles;

    /**
     * Creates a new User.
     *
     * @param id the unique identifier of the User
     * @param email the email of the User
     * @param passwordHash the hash of the password of the User
     * @param roles the roles of the User
     */
    public User(UserId id, String email, String passwordHash, Set<Role> roles) {
        // mini règles métier
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email is required");
        }
        this.id = id;
        this.email = email;
        this.passwordHash = passwordHash;
        this.roles = roles;
    }

    /**
     * Returns the unique identifier of the User.
     *
     * @return the unique identifier of the User
     */
    public UserId id() { return id; }
    /**
     * Returns the email of the User.
     *
     * @return the email of the User
     */
    public String email() { return email; }
    /**
     * Returns the hash of the password of the User.
     *
     * @return the hash of the password of the User
     */
    public String passwordHash() { return passwordHash; }
    /**
     * Returns the roles of the User.
     *
     * @return the roles of the User
     */
    public Set<Role> roles() { return roles; }

    /**
     * Checks if the User is an admin.
     *
     * @return true if the User is an admin, false otherwise
     */
    public boolean isAdmin() {
        return roles.contains(Role.ADMIN);
    }
}
