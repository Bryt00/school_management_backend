package com.raven.school_mgt_api.application.mapper;

import com.raven.school_mgt_api.application.dto.response.StudentResponse;
import com.raven.school_mgt_api.domain.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = {UserMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentMapper {
    StudentResponse toResponse(Student student);
}
