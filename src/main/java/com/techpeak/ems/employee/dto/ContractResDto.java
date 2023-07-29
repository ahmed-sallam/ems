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
public class ContractResDto {
    private Long id;
    private Instant startDate;
    private Instant endDate;
    private Integer duration;
    private String notes;
    private Boolean isActive;
    @JsonIgnore
    private PersonalResDto personal;
    private Instant createdAt;
}
