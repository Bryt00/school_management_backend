package com.raven.school_mgt_api.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    private UUID id;
    private String name;
    private String code;
    private Integer credits;
}
