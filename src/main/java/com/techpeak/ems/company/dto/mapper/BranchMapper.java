package com.techpeak.ems.company.dto.mapper;

import com.techpeak.ems.company.dto.BranchDto;
import com.techpeak.ems.company.dto.BranchResDto;
import com.techpeak.ems.company.dto.BranchWithDepartmentsDto;
import com.techpeak.ems.company.entities.Branch;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class BranchMapper {
    private  ModelMapper mapper;

    public BranchResDto toDto(Branch entity) {
        return mapper.map(entity, BranchResDto.class);
    }

    public BranchWithDepartmentsDto toDtoWithDepartments(Branch entity) {
        return mapper.map(entity, BranchWithDepartmentsDto.class);
    }

    public Branch toEntity(BranchDto dto) {
        return mapper.map(dto, Branch.class);
    }

    public List<BranchResDto> toListDto(List<Branch> entities){
        return entities
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

}
