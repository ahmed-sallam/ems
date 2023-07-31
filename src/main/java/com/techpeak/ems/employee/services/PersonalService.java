package com.techpeak.ems.employee.services;

import com.techpeak.ems.employee.dto.PersonalDto;
import com.techpeak.ems.employee.dto.PersonalResDto;
import com.techpeak.ems.employee.models.Personal;

import java.util.List;

public interface PersonalService {
    PersonalResDto createPersonal (PersonalDto personalDto);
    PersonalResDto findPersonal(Long id);
    List<PersonalResDto> listPersonals();
    PersonalResDto updatePersonal(PersonalDto personalDto);
    void deletePersonal(Long id);
    Personal findOrThrow(Long id);
}
