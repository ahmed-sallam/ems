package com.techpeak.ems.core.services;

import com.techpeak.ems.company.entities.DepartmentEntity;
import com.techpeak.ems.core.dto.AddressDto;
import com.techpeak.ems.core.dto.AddressResDto;

import java.util.List;

public interface AddressService {
    List<AddressResDto> listAddresses();
    AddressResDto findAddressById(Long id);
    AddressResDto createAddress(AddressDto dto);
    void deleteAddressById(Long id);
    AddressResDto updateAddress(Long id, AddressDto dto);
    DepartmentEntity findOrThrow(Long id);
}
