package com.techpeak.ems.company.services.impl;

import com.techpeak.ems.company.dto.DepartmentDto;
import com.techpeak.ems.company.dto.DepartmentResDto;
import com.techpeak.ems.company.entities.DepartmentEntity;
import com.techpeak.ems.company.services.DepartmentService;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {
    @Override
    public List<DepartmentResDto> listDepartments() {
        return null;
    }

    @Override
    public DepartmentResDto findDepartmentById(Long id) {
        return null;
    }

    @Override
    public DepartmentResDto createDepartment(DepartmentDto dto) {
        return null;
    }

    @Override
    public void deleteDepartmentById(Long id) {

    }

    @Override
    public DepartmentResDto updateDepartment(Long id, DepartmentDto dto) {
        return null;
    }

    @Override
    public DepartmentEntity findOrThrow(Long id) {
        return null;
    }
}
