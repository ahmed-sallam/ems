package com.techpeak.ems.core.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDto {
    private String name;
    private String countryCode;
    private String number;
    @JsonIgnore
    private Long branch;
}
