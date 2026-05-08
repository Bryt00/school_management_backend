package com.raven.school_mgt_api.infrastructure.persistence.mapper;

import com.raven.school_mgt_api.domain.model.User;
import com.raven.school_mgt_api.infrastructure.persistence.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserEntityMapper {
    UserEntity toEntity(User user);
    User toDomain(UserEntity entity);
}
