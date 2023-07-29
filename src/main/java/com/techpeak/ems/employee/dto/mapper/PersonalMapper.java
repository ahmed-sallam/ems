package com.techpeak.ems.employee.dto.mapper;

import com.techpeak.ems.employee.dto.PersonalDto;
import com.techpeak.ems.employee.dto.PersonalResDto;
import com.techpeak.ems.employee.models.Personal;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class PersonalMapper {
    private ModelMapper mapper;

    public PersonalResDto toDto(Personal entity) {
        return mapper.map(entity, PersonalResDto.class);
    }

    public Personal toEntity(PersonalDto dto) {
        return mapper.map(dto, Personal.class);
    }

    public List<PersonalResDto> toListDto(List<Personal> entities){
        return entities
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
