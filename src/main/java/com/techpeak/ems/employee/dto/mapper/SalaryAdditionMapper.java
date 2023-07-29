package com.techpeak.ems.employee.dto.mapper;


import com.techpeak.ems.employee.dto.SalaryAdditionDto;
import com.techpeak.ems.employee.dto.SalaryAdditionResDto;
import com.techpeak.ems.employee.models.SalaryAddition;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class SalaryAdditionMapper {
    private ModelMapper mapper;

    public SalaryAdditionResDto toDto(SalaryAddition entity) {
        return mapper.map(entity, SalaryAdditionResDto.class);
    }

    public SalaryAddition toEntity(SalaryAdditionDto dto) {
        return mapper.map(dto, SalaryAddition.class);
    }

    public List<SalaryAdditionResDto> toListDto(List<SalaryAddition> entities){
        return entities
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
