package com.techpeak.ems.core.dto.mapper;


import com.techpeak.ems.core.dto.AddressDto;
import com.techpeak.ems.core.dto.AddressResDto;
import com.techpeak.ems.core.entities.AddressEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class AddressMapper {
    private  ModelMapper mapper;

    public AddressResDto toDto(AddressEntity entity) {
        return mapper.map(entity, AddressResDto.class);
    }
    public AddressEntity toEntity(AddressDto dto) {
        return mapper.map(dto, AddressEntity.class);
    }

    public List<AddressResDto> toListDto(List<AddressEntity> entities){
        return entities
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

}
