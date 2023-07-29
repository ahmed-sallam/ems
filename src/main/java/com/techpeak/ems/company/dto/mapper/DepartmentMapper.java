package com.techpeak.ems.company.dto.mapper;

import com.techpeak.ems.company.dto.DepartmentDto;
import com.techpeak.ems.company.dto.DepartmentResDto;
import com.techpeak.ems.company.models.Department;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class DepartmentMapper {
    private  ModelMapper mapper;

    public DepartmentResDto toDto(Department entity) {
        return mapper.map(entity, DepartmentResDto.class);
    }
    public Department toEntity(DepartmentDto dto) {
        return mapper.map(dto, Department.class);
    }

    public List<DepartmentResDto> toListDto(List<Department> entities){
        return entities
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

}
