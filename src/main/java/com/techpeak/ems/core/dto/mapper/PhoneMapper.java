package com.techpeak.ems.core.dto.mapper;


import com.techpeak.ems.core.dto.PhoneDto;
import com.techpeak.ems.core.dto.PhoneResDto;
import com.techpeak.ems.core.entities.Phone;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class PhoneMapper {
    private ModelMapper mapper;

    public PhoneResDto toDto(Phone entity) {
        return mapper.map(entity, PhoneResDto.class);
    }

    public Phone toEntity(PhoneDto dto) {
        return mapper.map(dto, Phone.class);
    }

    public List<PhoneResDto> toListDto(List<Phone> entities) {
        return entities
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

}
