package com.techpeak.ems.employee.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContractDto {
    private Instant startDate;
    private Instant endDate;
    private Integer duration;
    private String notes;
    private Boolean isActive;
    private Long personal;
}
