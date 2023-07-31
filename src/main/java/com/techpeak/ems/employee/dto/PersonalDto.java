package com.techpeak.ems.employee.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonalDto {
    private Long id; // id used when update a record
    private String firstName;
    private String lastName;
    private String country;
    private String passportNo;
    private String email;
    private String gender;
    private Long department;
}
