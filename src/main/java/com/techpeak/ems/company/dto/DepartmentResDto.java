package com.techpeak.ems.company.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentResDto {
    private Long id;
    private String name;
    private Instant createdAt;
}
