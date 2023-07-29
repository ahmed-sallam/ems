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
public class WorkResDto {
    private String position;
    private Instant dutyFrom;
    private Instant dutyTo;
    @JsonIgnore
    private PersonalResDto personal;
    @JsonIgnore
    private PersonalResDto manager;
    private Instant createdAt;
}
