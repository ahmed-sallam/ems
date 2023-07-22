package com.techpeak.ems.company.dto.mapper;

import com.techpeak.ems.company.dto.BranchDto;
import com.techpeak.ems.company.dto.BranchResDto;
import com.techpeak.ems.company.dto.BranchWithDepartmentsDto;
import com.techpeak.ems.company.entities.BranchEntity;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class BranchMapper {
    private  ModelMapper mapper;

    public BranchResDto toDto(BranchEntity entity) {
        return mapper.map(entity, BranchResDto.class);
    }

    public BranchWithDepartmentsDto toDtoWithDepartments(BranchEntity entity) {
        return mapper.map(entity, BranchWithDepartmentsDto.class);
    }

    public BranchEntity toEntity(BranchDto dto) {
        return mapper.map(dto, BranchEntity.class);
    }

    public List<BranchResDto> toListDto(List<BranchEntity> entities){
        return entities
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

}
