package com.techpeak.ems.employee.dto;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkDto {
    private String position;
    private Instant dutyFrom;
    private Instant dutyTo;
    private Long personal;
    private Long manager;

}
