package com.techpeak.ems.core.services.impl;

import com.techpeak.ems.company.services.BranchService;
import com.techpeak.ems.core.dto.AddressDto;
import com.techpeak.ems.core.dto.AddressResDto;
import com.techpeak.ems.core.dto.mapper.AddressMapper;
import com.techpeak.ems.core.models.Address;
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
        List<Address> entities = repository.findAll();
        return mapper.toListDto(entities);
    }

    @Override
    public AddressResDto findAddressById(Long id) {
        Address entity = findOrThrow(id);
        return mapper.toDto(entity);
    }

    @Override
    public AddressResDto createAddress(AddressDto dto) {
        Address entity = mapper.toEntity(dto);
//        if(dto.getBranch() != null){
//        Branch branchEntity = branchService.findOrThrow(dto.getBranch());
//        }
        Address newEntity = repository.save(entity);
        return mapper.toDto(newEntity);
    }

    @Override
    public void deleteAddressById(Long id) {
        findOrThrow(id);
        repository.deleteById(id);
    }

    @Override
    public AddressResDto updateAddress(Long id, AddressDto dto) {
        Address entity = findOrThrow(id);
        entity.setName(dto.getName());
        Address newEntity = repository.save(entity);
        return mapper.toDto(newEntity);
    }

    @Override
    public Address findOrThrow(Long id) {
        return repository
                .findById(id)
                .orElseThrow(()->
                        new NotFoundException("Address With ID" + id + " " +
                                "does not exist"));
    }
}
