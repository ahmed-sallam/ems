package com.techpeak.ems.company.controllers;

import com.techpeak.ems.company.dto.DepartmentDto;
import com.techpeak.ems.company.dto.DepartmentResDto;
import com.techpeak.ems.company.services.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Optional.ofNullable;

@RestController()
@RequestMapping("/api/v1/departments")
@RequiredArgsConstructor
public class DepartmentRestController {

    private final DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<List<DepartmentResDto>> listDepartments(){
        List<DepartmentResDto> results = departmentService.listDepartments();
        return ResponseEntity.of(ofNullable(results));
    }

    @PostMapping
    public ResponseEntity<DepartmentResDto> createDepartment(@RequestBody @Valid DepartmentDto departmentDto){
        DepartmentResDto result =
                departmentService.createDepartment(departmentDto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentResDto> findDepartmentById(@PathVariable Long id){
        return ResponseEntity.ok(departmentService.findDepartmentById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteDepartmentById(@PathVariable Long id){
        departmentService.deleteDepartmentById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DepartmentResDto> updateDepartment(@PathVariable Long id,
                                              @RequestBody @Valid DepartmentDto departmentDto) {
        return ResponseEntity.ok(departmentService.updateDepartment(id, departmentDto));
    }


}
