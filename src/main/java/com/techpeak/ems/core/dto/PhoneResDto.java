package com.techpeak.ems.core.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PhoneResDto {
    private Long id;
    private String name;
    private String countryCode;
    private String number;
    private Instant createdAt;
}
