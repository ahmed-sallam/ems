package com.techpeak.ems.company.dto.mapper;

import com.techpeak.ems.company.dto.DepartmentDto;
import com.techpeak.ems.company.dto.BranchResDto;
import com.techpeak.ems.company.dto.DepartmentResDto;
import com.techpeak.ems.company.entities.DepartmentEntity;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class DeparmentMapper {
    private  ModelMapper mapper;

    public DepartmentResDto toDto(DepartmentEntity entity) {
        return mapper.map(entity, DepartmentResDto.class);
    }
    public DepartmentEntity toEntity(DepartmentDto dto) {
        return mapper.map(dto, DepartmentEntity.class);
    }

    public List<DepartmentResDto> toListDto(List<DepartmentEntity> entities){
        return entities
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

}
