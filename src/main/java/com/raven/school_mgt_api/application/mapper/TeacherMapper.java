package com.raven.school_mgt_api.application.mapper;

import com.raven.school_mgt_api.application.dto.response.TeacherResponse;
import com.raven.school_mgt_api.domain.model.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = {UserMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TeacherMapper {
    TeacherResponse toResponse(Teacher teacher);
}
