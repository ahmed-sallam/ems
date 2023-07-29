package com.techpeak.ems.employee.dto;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SalaryAdditionDto {
    private String name;
    private Integer amount;
    private Long salary;

}
