package com.techpeak.ems.employee.dto.mapper;

import com.techpeak.ems.company.models.Branch;
import com.techpeak.ems.employee.dto.ContractDto;
import com.techpeak.ems.employee.dto.ContractResDto;
import com.techpeak.ems.employee.models.Contract;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ContractMapper {
    private ModelMapper mapper;

    public ContractResDto toDto(Contract entity) {
        return mapper.map(entity, ContractResDto.class);
    }

    public Contract toEntity(ContractDto dto) {
        return mapper.map(dto, Contract.class);
    }

    public List<ContractResDto> toListDto(List<Contract> entities){
        return entities
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
