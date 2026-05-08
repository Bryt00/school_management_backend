package com.raven.school_mgt_api.application.dto.response;

import com.raven.school_mgt_api.domain.model.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeacherResponse {
    private UUID id;
    private UserResponse user;
    private String firstName;
    private String lastName;
    private Gender gender;
    private String employeeId;
    private String qualification;
}
