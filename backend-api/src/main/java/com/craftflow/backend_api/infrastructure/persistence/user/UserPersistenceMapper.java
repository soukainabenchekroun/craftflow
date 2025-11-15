package com.craftflow.backend_api.infrastructure.persistence.user;

import com.craftflow.backend_api.domain.user.Role;
import com.craftflow.backend_api.domain.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * A mapper for converting between User domain objects and UserEntity persistence objects.
 */
@Mapper(componentModel = "spring")
public interface UserPersistenceMapper {

    /**
     * Converts a User domain object to a UserEntity persistence object.
     *
     * @param user the User domain object
     * @return the UserEntity persistence object
     */
    @Mapping(target = "id", expression = "java(user.id().value())")
    @Mapping(target = "passwordHash", source = "passwordHash")
    @Mapping(target = "roles", expression = "java(mapRolesToStrings(user.roles()))")
    UserEntity toEntity(User user);

    /**
     * Converts a UserEntity persistence object to a User domain object.
     *
     * @param entity the UserEntity persistence object
     * @return the User domain object
     */
    @Mapping(target = "id", expression = "java(new UserId(entity.getId()))")
    @Mapping(target = "passwordHash", source = "passwordHash")
    @Mapping(target = "roles", expression = "java(mapStringsToRoles(entity.getRoles()))")
    User toDomain(UserEntity entity);

    /**
     * Maps a set of Role enums to a set of their string representations.
     *
     * @param roles the set of Role enums
     * @return the set of string representations of the roles
     */
    default Set<String> mapRolesToStrings(Set<Role> roles) {
        return roles.stream().map(Enum::name).collect(Collectors.toSet());
    }

    /**
     * Maps a set of role strings to a set of Role enums.
     *
     * @param roles the set of role strings
     * @return the set of Role enums
     */
    default Set<Role> mapStringsToRoles(Set<String> roles) {
        return roles.stream().map(Role::valueOf).collect(Collectors.toSet());
    }
}
