package com.techpeak.ems.employee.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SalaryAdditionResDto {
    private Long id;
    private String name;
    private Integer amount;
    @JsonIgnore
    private SalaryResDto salary;
    private Instant createdAt;


}
