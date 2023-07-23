package com.techpeak.ems.core.services.impl;

import com.techpeak.ems.company.entities.DepartmentEntity;
import com.techpeak.ems.core.dto.AddressDto;
import com.techpeak.ems.core.dto.AddressResDto;
import com.techpeak.ems.core.repositories.AddressRepository;
import com.techpeak.ems.core.services.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository repository;

    @Override
    public List<AddressResDto> listAddresses() {
        return null;
    }

    @Override
    public AddressResDto findAddressById(Long id) {
        return null;
    }

    @Override
    public AddressResDto createAddress(AddressDto dto) {
        return null;
    }

    @Override
    public void deleteAddressById(Long id) {

    }

    @Override
    public AddressResDto updateAddress(Long id, AddressDto dto) {
        return null;
    }

    @Override
    public DepartmentEntity findOrThrow(Long id) {
        return null;
    }
}
