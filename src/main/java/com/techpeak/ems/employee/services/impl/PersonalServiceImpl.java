package com.techpeak.ems.employee.services.impl;

import com.techpeak.ems.company.models.Department;
import com.techpeak.ems.company.services.DepartmentService;
import com.techpeak.ems.employee.dto.PersonalDto;
import com.techpeak.ems.employee.dto.PersonalResDto;
import com.techpeak.ems.employee.dto.mapper.PersonalMapper;
import com.techpeak.ems.employee.enumerations.GenderEnum;
import com.techpeak.ems.employee.models.Personal;
import com.techpeak.ems.employee.repositories.PersonalRepository;
import com.techpeak.ems.employee.services.PersonalService;
import com.techpeak.ems.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonalServiceImpl implements PersonalService {
    private final PersonalRepository repository;
    private final PersonalMapper mapper;
    private final DepartmentService departmentService;
    @Override
    public PersonalResDto createPersonal(PersonalDto personalDto) {
        Personal entity = mapper.toEntity(personalDto);
        Department department =
                departmentService.findOrThrow(personalDto.getDepartment());
        entity.setGender(GenderEnum.valueOf(personalDto.getGender().toUpperCase()));
        entity.setDepartment(department);
        Personal newEntity = repository.save(entity);
        return mapper.toDto(newEntity);
    }

    @Override
    public PersonalResDto findPersonal(Long id) {
        Personal entity = findOrThrow(id);
        return mapper.toDto(entity);
    }

    @Override
    public List<PersonalResDto> listPersonals() {
        List<Personal> entities = repository.findAll();
        return mapper.toListDto(entities);
    }

    @Override
    public PersonalResDto updatePersonal(PersonalDto personalDto) {
        Personal entity = findOrThrow(personalDto.getId());
        Department department =
                departmentService
                        .findOrThrow(personalDto.getDepartment());
        entity.setFirstName(personalDto.getFirstName());
        entity.setLastName(personalDto.getLastName());
        entity.setCountry(personalDto.getCountry());
        entity.setPassportNo(personalDto.getPassportNo());
        entity.setEmail(personalDto.getEmail());
        entity.setGender(GenderEnum.valueOf(personalDto.getGender().toUpperCase()));
        entity.setDepartment(department);
        Personal newEntity = repository.save(entity);
        return mapper.toDto(newEntity);
    }

    @Override
    public void deletePersonal(Long id) {
        findOrThrow(id);
        repository.deleteById(id);
    }

    @Override
    public Personal findOrThrow(Long id) {
        return repository
                .findById(id)
                .orElseThrow(()->
                        new NotFoundException("Personal With ID" + id + " does not exist"));
    }
}
