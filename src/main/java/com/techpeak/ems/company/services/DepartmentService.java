package com.techpeak.ems.company.services;

import com.techpeak.ems.company.dto.DepartmentDto;
import com.techpeak.ems.company.dto.DepartmentResDto;
import com.techpeak.ems.company.models.Department;

import java.util.List;

public interface DepartmentService {
    List<DepartmentResDto> listDepartments();
    DepartmentResDto findDepartmentById(Long id);
    DepartmentResDto createDepartment(DepartmentDto dto);
    void deleteDepartmentById(Long id);
    DepartmentResDto updateDepartment(Long id, DepartmentDto dto);
    Department findOrThrow(Long id);
}
