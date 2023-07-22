package com.techpeak.ems.company.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BranchWithDepartmentsDto {
    private Long id;
    private String name;
    private Instant createdAt;
    private List<DepartmentResDto> departments;
}
