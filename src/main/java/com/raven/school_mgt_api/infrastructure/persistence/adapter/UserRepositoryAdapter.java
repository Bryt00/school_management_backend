package com.raven.school_mgt_api.infrastructure.persistence.adapter;

import com.raven.school_mgt_api.domain.model.User;
import com.raven.school_mgt_api.domain.repository.UserRepository;
import com.raven.school_mgt_api.infrastructure.persistence.entity.UserEntity;
import com.raven.school_mgt_api.infrastructure.persistence.mapper.UserEntityMapper;
import com.raven.school_mgt_api.infrastructure.persistence.repository.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepository {

    private final JpaUserRepository jpaUserRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    public User save(User user) {
        UserEntity entity = userEntityMapper.toEntity(user);
        UserEntity savedEntity = jpaUserRepository.save(entity);
        return userEntityMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<User> findById(UUID id) {
        return jpaUserRepository.findById(id)
                .map(userEntityMapper::toDomain);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return jpaUserRepository.findByEmail(email)
                .map(userEntityMapper::toDomain);
    }
}
