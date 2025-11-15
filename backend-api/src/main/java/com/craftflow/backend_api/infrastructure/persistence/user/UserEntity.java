package com.craftflow.backend_api.infrastructure.persistence.user;

import jakarta.persistence.*;
import java.util.Set;
import java.util.UUID;

/**
 * An entity representing a User.
 */
@Entity
@Table(name = "users")
public class UserEntity {

    /**
     * The unique identifier of the User.
     */
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    /**
     * The email of the User.
     */
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    /**
     * The hash of the password of the User.
     */
    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    /**
     * The roles of the User.
     */
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    private Set<String> roles;

    /**
     * Creates a new UserEntity.
     */
    protected UserEntity() {}

    /**
     * Creates a new UserEntity.
     *
     * @param id the unique identifier of the User
     * @param email the email of the User
     * @param passwordHash the hash of the password of the User
     * @param roles the roles of the User
     */
    public UserEntity(UUID id, String email, String passwordHash, Set<String> roles) {
        this.id = id;
        this.email = email;
        this.passwordHash = passwordHash;
        this.roles = roles;
    }

    public UUID getId() { return id; }
    public String getEmail() { return email; }
    public String getPasswordHash() { return passwordHash; }
    public Set<String> getRoles() { return roles; }

    public void setId(UUID id) { this.id = id; }
    public void setEmail(String email) { this.email = email; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }
    public void setRoles(Set<String> roles) { this.roles = roles; }
}