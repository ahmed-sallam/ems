package com.techpeak.ems.company.controllers;

import com.techpeak.ems.company.dto.DepartmentDto;
import com.techpeak.ems.company.dto.DepartmentResDto;
import com.techpeak.ems.company.dto.BranchWithDepartmentsDto;
import com.techpeak.ems.company.services.BranchService;
import com.techpeak.ems.company.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static java.util.Optional.ofNullable;

@RestController()
@RequestMapping("/api/v1/departments")
@RequiredArgsConstructor
public class DepartmentRestController {

    private final DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<List<DepartmentResDto>> getAllBranches(){
        List<DepartmentResDto> results = departmentService.listDepartments();
        return ResponseEntity.of(ofNullable(results));
    }

    @PostMapping
    public ResponseEntity<DepartmentResDto> postBranch(@RequestBody Map<String
                    , DepartmentDto> dto){
        DepartmentDto departmentDto = dto.get("department");
        DepartmentResDto result =
                departmentService.createDepartment(departmentDto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentResDto> getDepartmentById(@PathVariable Long id){
        DepartmentResDto result;
        try {
         result = departmentService.findDepartmentById(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteDepartmentById(@PathVariable Long id){
        try {

        departmentService.deleteDepartmentById(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DepartmentResDto> updateDepartmentById(@PathVariable Long id,
                                              @RequestBody Map<String
            , DepartmentDto> dto) {
        DepartmentDto departmentDto = dto.get("department");
        DepartmentResDto result;
        try {
            result = departmentService.updateDepartment(id, departmentDto);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(result);
    }


}
