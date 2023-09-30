package com.teaminternational.enterthezone.infrastructure.persistence.user;

import com.teaminternational.enterthezone.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserEntityMapper {

    public User mapToDomainEntity(UserEntity dbEntity) {
        return new User(
                dbEntity.getId(),
                dbEntity.getFirstName(),
                dbEntity.getLastName()
        );
    }

    public UserEntity mapToDatabaseEntity(User domainEntity) {
        return new UserEntity(
                domainEntity.id(),
                domainEntity.firstName(),
                domainEntity.lastName()
        );
    }
}
