package com.techpeak.ems.employee.dto;


import com.techpeak.ems.employee.enumerations.GenderEnum;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonalDto {
    private String firstName;
    private String lastName;
    private String country;
    private String passportNo;
    private String email;
    private String gender;
    private Long department;
}
