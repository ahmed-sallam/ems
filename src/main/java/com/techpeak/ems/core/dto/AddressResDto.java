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
public class AddressResDto {
    private Long id;
    private String name;
    private String street;
    private String city;
    private String country;
    private Instant createdAt;
}
