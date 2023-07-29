package com.techpeak.ems.core.dto.mapper;


import com.techpeak.ems.core.dto.AddressDto;
import com.techpeak.ems.core.dto.AddressResDto;
import com.techpeak.ems.core.models.Address;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class AddressMapper {
    private  ModelMapper mapper;

    public AddressResDto toDto(Address entity) {
        return mapper.map(entity, AddressResDto.class);
    }
    public Address toEntity(AddressDto dto) {
        return mapper.map(dto, Address.class);
    }

    public List<AddressResDto> toListDto(List<Address> entities){
        return entities
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

}
