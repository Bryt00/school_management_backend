package com.raven.school_mgt_api.application.mapper;

import com.raven.school_mgt_api.application.dto.response.UserResponse;
import com.raven.school_mgt_api.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserResponse toResponse(User user);
}
