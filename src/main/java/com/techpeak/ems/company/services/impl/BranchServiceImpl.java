package com.techpeak.ems.company.services.impl;

import com.techpeak.ems.company.dto.BranchDto;
import com.techpeak.ems.company.dto.BranchResDto;
import com.techpeak.ems.company.dto.BranchWithDepartmentsDto;
import com.techpeak.ems.company.dto.mapper.BranchMapper;
import com.techpeak.ems.company.entities.BranchEntity;
import com.techpeak.ems.company.repositories.BranchRepository;
import com.techpeak.ems.company.services.BranchService;
import com.techpeak.ems.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {
    private final BranchRepository repository;
    private final BranchMapper mapper;
    @Override
    public List<BranchResDto> listBranches() {
        List<BranchEntity> entities = repository.findAll();
        return mapper.toListDto(entities);
    }

    @Override
    public BranchResDto findBranchById(Long id) {
        BranchEntity entity = findOrThrow(id);
        return mapper.toDto(entity);
    }

    @Override
    public BranchResDto createBranch(BranchDto dto) {
        BranchEntity entity = mapper.toEntity(dto);
        BranchEntity newEntity = repository.save(entity);
        return mapper.toDto(newEntity);

    }

    @Override
    public void deleteBranchById(Long id) {
        findOrThrow(id);
        repository.deleteById(id);
    }

    @Override
    public BranchResDto updateBranch(Long id, BranchDto dto) {
        BranchEntity entity = findOrThrow(id);
        entity.setName(dto.getName());
        BranchEntity newEntity = repository.save(entity);
        return mapper.toDto(newEntity);
    }

    @Override
    public BranchWithDepartmentsDto findBranchWithDepartmentsById(Long id) {
        findOrThrow(id);
        BranchEntity entity = repository.findByIdAndFetchDepartments(id);
        return mapper.toDtoWithDepartments(entity);
    }

    @Override
    public BranchEntity findOrThrow(Long id) {
        return repository
                .findById(id)
                .orElseThrow(()->
                        new NotFoundException("Branch With ID" + id + " does not exist"));
    }
}
