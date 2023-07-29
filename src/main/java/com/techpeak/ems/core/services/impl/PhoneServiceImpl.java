package com.techpeak.ems.core.services.impl;

import com.techpeak.ems.company.entities.Branch;
import com.techpeak.ems.company.services.BranchService;
import com.techpeak.ems.core.dto.PhoneDto;
import com.techpeak.ems.core.dto.PhoneResDto;
import com.techpeak.ems.core.dto.mapper.PhoneMapper;
import com.techpeak.ems.core.entities.PhoneEntity;
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
        List<PhoneEntity> entities = repository.findAll();
        return mapper.toListDto(entities);
    }

    @Override
    public PhoneResDto findPhoneById(Long id) {
        PhoneEntity entity = findOrThrow(id);
        return mapper.toDto(entity);
    }

    @Override
    public PhoneResDto createPhone(PhoneDto dto) {
        PhoneEntity entity = mapper.toEntity(dto);
        if(dto.getBranch() != null){
            Branch branchEntity = branchService.findOrThrow(dto.getBranch());
            entity.setBranch(branchEntity);
        }
        PhoneEntity newEntity = repository.save(entity);
        return mapper.toDto(newEntity);
    }

    @Override
    public void deletePhoneById(Long id) {
        findOrThrow(id);
        repository.deleteById(id);
    }

    @Override
    public PhoneResDto updatePhone(Long id, PhoneDto dto) {
        PhoneEntity entity = findOrThrow(id);
        entity.setName(dto.getName());
        PhoneEntity newEntity = repository.save(entity);
        return mapper.toDto(newEntity);
    }

    @Override
    public PhoneEntity findOrThrow(Long id) {
        return repository
                .findById(id)
                .orElseThrow(()->
                        new NotFoundException("Phone With ID" + id + " " +
                                "does not exist"));
    }
}
