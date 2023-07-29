package com.techpeak.ems.employee.dto.mapper;

import com.techpeak.ems.employee.dto.WorkDto;
import com.techpeak.ems.employee.dto.WorkResDto;
import com.techpeak.ems.employee.models.Work;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class WorkMapper {
    private ModelMapper mapper;

    public WorkResDto toDto(Work entity) {
        return mapper.map(entity, WorkResDto.class);
    }

    public Work toEntity(WorkDto dto) {
        return mapper.map(dto, Work.class);
    }

    public List<WorkResDto> toListDto(List<Work> entities){
        return entities
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
