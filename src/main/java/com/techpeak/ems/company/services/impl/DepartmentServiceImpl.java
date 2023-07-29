package com.techpeak.ems.company.services.impl;

import com.techpeak.ems.company.dto.DepartmentDto;
import com.techpeak.ems.company.dto.DepartmentResDto;
import com.techpeak.ems.company.dto.mapper.DepartmentMapper;
import com.techpeak.ems.company.entities.Branch;
import com.techpeak.ems.company.entities.DepartmentEntity;
import com.techpeak.ems.company.repositories.DepartmentRepository;
import com.techpeak.ems.company.services.BranchService;
import com.techpeak.ems.company.services.DepartmentService;
import com.techpeak.ems.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository repository;
    private final DepartmentMapper mapper;
    private final BranchService branchService;

    @Override
    public List<DepartmentResDto> listDepartments() {
        List<DepartmentEntity> entities = repository.findAll();
        return mapper.toListDto(entities);
    }

    @Override
    public DepartmentResDto findDepartmentById(Long id) {

        DepartmentEntity entity = findOrThrow(id);
        return mapper.toDto(entity);
    }

    @Override
    public DepartmentResDto createDepartment(DepartmentDto dto) {

        DepartmentEntity entity = mapper.toEntity(dto);
        Branch branchEntity = branchService.findOrThrow(dto.getBranch());
        entity.setBranch(branchEntity);
        DepartmentEntity newEntity = repository.save(entity);
        return mapper.toDto(newEntity);
    }

    @Override
    public void deleteDepartmentById(Long id) {
        findOrThrow(id);
        repository.deleteById(id);
    }

    @Override
    public DepartmentResDto updateDepartment(Long id, DepartmentDto dto) {
        DepartmentEntity entity = findOrThrow(id);
        entity.setName(dto.getName());
        DepartmentEntity newEntity = repository.save(entity);
        return mapper.toDto(newEntity);
    }

    @Override
    public DepartmentEntity findOrThrow(Long id) {
        return repository
                .findById(id)
                .orElseThrow(()->
                        new NotFoundException("Department With ID" + id + " " +
                                "does not exist"));
    }
}
