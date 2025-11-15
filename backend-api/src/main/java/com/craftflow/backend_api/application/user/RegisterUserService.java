package com.craftflow.backend_api.application.user;

import com.craftflow.backend_api.application.user.port.UserRepository;
import com.craftflow.backend_api.domain.user.Role;
import com.craftflow.backend_api.domain.user.User;
import com.craftflow.backend_api.domain.user.UserId;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * A service for registering a new user.
 */
@Service
public class RegisterUserService {

    /**
     * The repository for managing users.
     */
    private final UserRepository userRepository;
    /**
     * The password encoder for encoding passwords.
     */
    private final PasswordEncoder passwordEncoder;

    /**
     * Creates a new RegisterUserService.
     *
     * @param userRepository the repository for managing users
     * @param passwordEncoder the password encoder for encoding passwords
     */
    public RegisterUserService(UserRepository userRepository,
                               PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Handles a register user command.
     *
     * @param command the command to handle
     * @return the result of the command
     */
    public RegisterUserResult handle(RegisterUserCommand command) {
        userRepository.findByEmail(command.email())
                .ifPresent(u -> {
                    throw new IllegalArgumentException("Email already in use");
                });

        var user = new User(
                UserId.newId(),
                command.email(),
                passwordEncoder.encode(command.password()),
                Set.of(Role.MEMBER)
        );

        var saved = userRepository.save(user);

        return new RegisterUserResult(
                saved.id().value(),
                saved.email()
        );
    }
}

