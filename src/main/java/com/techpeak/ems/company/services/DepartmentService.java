package com.techpeak.ems.company.services;

import com.techpeak.ems.company.dto.DepartmentDto;
import com.techpeak.ems.company.dto.BranchWithDepartmentsDto;
import com.techpeak.ems.company.dto.DepartmentResDto;
import com.techpeak.ems.company.entities.BranchEntity;
import com.techpeak.ems.company.entities.DepartmentEntity;

import java.util.List;

public interface DepartmentService {
    List<DepartmentResDto> listDepartments();
    DepartmentResDto findDepartmentById(Long id);
    DepartmentResDto createDepartment(DepartmentDto dto);
    void deleteDepartmentById(Long id);
    DepartmentResDto updateDepartment(Long id, DepartmentDto dto);
    DepartmentEntity findOrThrow(Long id);
}
