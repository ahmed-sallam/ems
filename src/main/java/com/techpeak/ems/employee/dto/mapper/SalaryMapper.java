package com.techpeak.ems.employee.dto.mapper;

import com.techpeak.ems.employee.dto.SalaryDto;
import com.techpeak.ems.employee.dto.SalaryResDto;
import com.techpeak.ems.employee.models.Salary;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class SalaryMapper {
    private ModelMapper mapper;

    public SalaryResDto toDto(Salary entity) {
        return mapper.map(entity, SalaryResDto.class);
    }

    public Salary toEntity(SalaryDto dto) {
        return mapper.map(dto, Salary.class);
    }

    public List<SalaryResDto> toListDto(List<Salary> entities){
        return entities
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
