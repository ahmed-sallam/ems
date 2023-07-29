package com.techpeak.ems.company.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BranchResDto {
    private Long id;
    private String name;
    private String address;
    // todo: add address & phone  fields
}
