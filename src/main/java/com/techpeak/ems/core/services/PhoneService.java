package com.techpeak.ems.core.services;

import com.techpeak.ems.company.entities.DepartmentEntity;
import com.techpeak.ems.core.dto.AddressDto;
import com.techpeak.ems.core.dto.AddressResDto;
import com.techpeak.ems.core.dto.PhoneDto;
import com.techpeak.ems.core.dto.PhoneResDto;
import com.techpeak.ems.core.entities.PhoneEntity;

import java.util.List;

public interface PhoneService {
    List<PhoneResDto> listPhones();
    PhoneResDto findPhoneById(Long id);
    PhoneResDto createPhone(PhoneDto dto);
    void deletePhoneById(Long id);
    PhoneResDto updatePhone(Long id, PhoneDto dto);
    PhoneEntity findOrThrow(Long id);
}
