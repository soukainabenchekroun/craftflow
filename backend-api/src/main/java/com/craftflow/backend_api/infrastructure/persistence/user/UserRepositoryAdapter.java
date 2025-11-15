package com.craftflow.backend_api.infrastructure.persistence.user;

import com.craftflow.backend_api.application.user.port.UserRepository;
import com.craftflow.backend_api.domain.user.User;
import com.craftflow.backend_api.domain.user.UserId;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * An adapter for the UserRepository that uses JPA for persistence.
 */
@Repository
public class UserRepositoryAdapter implements UserRepository {

    /** The JPA repository for UserEntity. */
    private final UserJpaRepository jpaRepository;
    /** The mapper for converting between User and UserEntity. */
    private final UserPersistenceMapper mapper;

    /**
     * Creates a new UserRepositoryAdapter.
     *
     * @param jpaRepository the JPA repository for UserEntity
     * @param mapper the mapper for converting between User and UserEntity
     */
    public UserRepositoryAdapter(UserJpaRepository jpaRepository,
                                 UserPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    /**
     * Saves a user.
     *
     * @param user the user to save
     * @return the saved user
     */
    @Override
    public User save(User user) {
        var entity = mapper.toEntity(user);
        var saved = jpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    /**
     * Finds a user by email.
     *
     * @param email the email of the user to find
     * @return the user if found
     */
    @Override
    public Optional<User> findByEmail(String email) {
        return jpaRepository.findByEmail(email).map(mapper::toDomain);
    }

    /**
     * Finds a user by id.
     *
     * @param id the id of the user to find
     * @return the user if found
     */
    @Override
    public Optional<User> findById(UserId id) {
        return jpaRepository.findById(id.value()).map(mapper::toDomain);
    }
}

