package com.techpeak.ems.core.dto.mapper;


import com.techpeak.ems.core.dto.PhoneDto;
import com.techpeak.ems.core.dto.PhoneResDto;
import com.techpeak.ems.core.entities.PhoneEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class PhoneMapper {
    private ModelMapper mapper;

    public PhoneResDto toDto(PhoneEntity entity) {
        return mapper.map(entity, PhoneResDto.class);
    }

    public PhoneEntity toEntity(PhoneDto dto) {
        return mapper.map(dto, PhoneEntity.class);
    }

    public List<PhoneResDto> toListDto(List<PhoneEntity> entities) {
        return entities
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

}
