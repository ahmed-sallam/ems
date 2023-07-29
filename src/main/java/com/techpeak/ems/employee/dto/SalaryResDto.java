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
public class SalaryResDto {
    private Long id;
    private Integer amount;
    @JsonIgnore
    private PersonalResDto personal;
    @JsonIgnore
    private SalaryAdditionResDto salaryAdditions;

    private Instant createdAt;

}
