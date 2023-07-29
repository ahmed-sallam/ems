package com.techpeak.ems.core.services;

import com.techpeak.ems.core.dto.PhoneDto;
import com.techpeak.ems.core.dto.PhoneResDto;
import com.techpeak.ems.core.models.Phone;

import java.util.List;

public interface PhoneService {
    List<PhoneResDto> listPhones();
    PhoneResDto findPhoneById(Long id);
    PhoneResDto createPhone(PhoneDto dto);
    void deletePhoneById(Long id);
    PhoneResDto updatePhone(Long id, PhoneDto dto);
    Phone findOrThrow(Long id);
}
