package com.techpeak.ems.core.services.impl;

import com.techpeak.ems.company.entities.Branch;
import com.techpeak.ems.company.services.BranchService;
import com.techpeak.ems.core.dto.AddressDto;
import com.techpeak.ems.core.dto.AddressResDto;
import com.techpeak.ems.core.dto.mapper.AddressMapper;
import com.techpeak.ems.core.entities.AddressEntity;
import com.techpeak.ems.core.repositories.AddressRepository;
import com.techpeak.ems.core.services.AddressService;
import com.techpeak.ems.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository repository;
    private final AddressMapper mapper;
    private final BranchService branchService;

    @Override
    public List<AddressResDto> listAddresses() {
        List<AddressEntity> entities = repository.findAll();
        return mapper.toListDto(entities);
    }

    @Override
    public AddressResDto findAddressById(Long id) {
        AddressEntity entity = findOrThrow(id);
        return mapper.toDto(entity);
    }

    @Override
    public AddressResDto createAddress(AddressDto dto) {
        AddressEntity entity = mapper.toEntity(dto);
        if(dto.getBranch() != null){
        Branch branchEntity = branchService.findOrThrow(dto.getBranch());
        entity.setBranch(branchEntity);
        }
        AddressEntity newEntity = repository.save(entity);
        return mapper.toDto(newEntity);
    }

    @Override
    public void deleteAddressById(Long id) {
        findOrThrow(id);
        repository.deleteById(id);
    }

    @Override
    public AddressResDto updateAddress(Long id, AddressDto dto) {
        AddressEntity entity = findOrThrow(id);
        entity.setName(dto.getName());
        AddressEntity newEntity = repository.save(entity);
        return mapper.toDto(newEntity);
    }

    @Override
    public AddressEntity findOrThrow(Long id) {
        return repository
                .findById(id)
                .orElseThrow(()->
                        new NotFoundException("Address With ID" + id + " " +
                                "does not exist"));
    }
}
