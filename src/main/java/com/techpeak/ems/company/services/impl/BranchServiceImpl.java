package com.techpeak.ems.company.services.impl;

import com.techpeak.ems.company.dto.BranchDto;
import com.techpeak.ems.company.dto.BranchResDto;
import com.techpeak.ems.company.dto.BranchWithDepartmentsDto;
import com.techpeak.ems.company.dto.mapper.BranchMapper;
import com.techpeak.ems.company.entities.Branch;
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
        List<Branch> entities = repository.findAll();
        return mapper.toListDto(entities);
    }

    @Override
    public BranchResDto findBranchById(Long id) {
        Branch entity = findOrThrow(id);
        return mapper.toDto(entity);
    }

    @Override
    public BranchResDto createBranch(BranchDto dto) {
//        BranchEntity entity = mapper.toEntity(dto);
//        BranchEntity newEntity = repository.save(entity);
//        return mapper.toDto(newEntity);
        return mapper.toDto(repository.save(mapper.toEntity(dto)));

    }

    @Override
    public void deleteBranchById(Long id) {
        findOrThrow(id);
        repository.deleteById(id);
    }

    @Override
    public BranchResDto updateBranch(Long id, BranchDto dto) {
        Branch entity = findOrThrow(id);
        entity.setName(dto.getName());
        Branch newEntity = repository.save(entity);
        return mapper.toDto(newEntity);
    }

    @Override
    public BranchWithDepartmentsDto findDepartmentsOfBranch(Long id) {
        findOrThrow(id);
        Branch entity = repository.findByIdAndFetchDepartments(id);
        return mapper.toDtoWithDepartments(entity);
    }

    @Override
    public Branch findOrThrow(Long id) {
        return repository
                .findById(id)
                .orElseThrow(()->
                        new NotFoundException("Branch With ID" + id + " does not exist"));
    }
}
