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
public class SchoolClass {
    private UUID id;
    private String name; // e.g., "Grade 10" or "Form 1"
    private String section; // e.g., "A", "Science"
    private Integer academicYear; 
}
