package com.techpeak.ems.core.services.impl;

import com.techpeak.ems.company.models.Branch;
import com.techpeak.ems.company.services.BranchService;
import com.techpeak.ems.core.dto.PhoneDto;
import com.techpeak.ems.core.dto.PhoneResDto;
import com.techpeak.ems.core.dto.mapper.PhoneMapper;
import com.techpeak.ems.core.models.Phone;
import com.techpeak.ems.core.repositories.PhoneRepository;
import com.techpeak.ems.core.services.PhoneService;
import com.techpeak.ems.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhoneServiceImpl implements PhoneService {
    private final PhoneRepository repository;
    private  final PhoneMapper mapper;
    private final BranchService branchService;

    @Override
    public List<PhoneResDto> listPhones() {
        List<Phone> entities = repository.findAll();
        return mapper.toListDto(entities);
    }

    @Override
    public PhoneResDto findPhoneById(Long id) {
        Phone entity = findOrThrow(id);
        return mapper.toDto(entity);
    }

    @Override
    public PhoneResDto createPhone(PhoneDto dto) {
        Phone entity = mapper.toEntity(dto);
        if(dto.getBranch() != null){
            Branch branchEntity = branchService.findOrThrow(dto.getBranch());
            entity.setBranch(branchEntity);
        }
        Phone newEntity = repository.save(entity);
        return mapper.toDto(newEntity);
    }

    @Override
    public void deletePhoneById(Long id) {
        findOrThrow(id);
        repository.deleteById(id);
    }

    @Override
    public PhoneResDto updatePhone(Long id, PhoneDto dto) {
        Phone entity = findOrThrow(id);
        entity.setName(dto.getName());
        Phone newEntity = repository.save(entity);
        return mapper.toDto(newEntity);
    }

    @Override
    public Phone findOrThrow(Long id) {
        return repository
                .findById(id)
                .orElseThrow(()->
                        new NotFoundException("Phone With ID" + id + " " +
                                "does not exist"));
    }
}
