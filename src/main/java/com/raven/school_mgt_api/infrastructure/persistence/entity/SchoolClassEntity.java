package com.raven.school_mgt_api.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "school_classes")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SchoolClassEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String section;

    @Column(name = "academic_year", nullable = false)
    private Integer academicYear;
}
