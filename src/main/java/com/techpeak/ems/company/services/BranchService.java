package com.techpeak.ems.company.services;

import com.techpeak.ems.company.dto.BranchDto;
import com.techpeak.ems.company.dto.BranchResDto;
import com.techpeak.ems.company.dto.BranchWithDepartmentsDto;
import com.techpeak.ems.company.models.Branch;

import java.util.List;

public interface BranchService {
    List<BranchResDto> listBranches();
    BranchResDto findBranchById(Long id);
    BranchResDto createBranch(BranchDto dto);
    void deleteBranchById(Long id);
    BranchResDto updateBranch(Long id, BranchDto dto);
    BranchWithDepartmentsDto findDepartmentsOfBranch(Long id);
    Branch findOrThrow(Long id);
}
