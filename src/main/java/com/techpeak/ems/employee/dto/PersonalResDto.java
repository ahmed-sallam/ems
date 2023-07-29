package com.techpeak.ems.employee.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.techpeak.ems.company.dto.DepartmentResDto;
import com.techpeak.ems.core.dto.AddressResDto;
import com.techpeak.ems.core.dto.PhoneResDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonalResDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String country;
    private String passportNo;
    private String email;
    private String gender;
    @JsonIgnore
    private DepartmentResDto department;
    @JsonIgnore
    private PhoneResDto phones;
    @JsonIgnore
    private AddressResDto addresses;
    @JsonIgnore
    private ContractResDto contracts;
    @JsonIgnore
    private SalaryResDto salary;
    @JsonIgnore
    private WorkResDto work;
    @JsonIgnore
    private PersonalResDto manager;
    private Instant createdAt;
}
