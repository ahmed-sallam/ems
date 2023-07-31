package com.techpeak.ems.company.controllers;

import com.techpeak.ems.company.dto.BranchDto;
import com.techpeak.ems.company.dto.BranchResDto;
import com.techpeak.ems.company.dto.BranchWithDepartmentsDto;
import com.techpeak.ems.company.services.BranchService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Optional.ofNullable;

@RestController()
@RequestMapping("/api/v1/branches")
@RequiredArgsConstructor
public class BranchRestController {

    private final BranchService branchservice;

    @GetMapping
    public ResponseEntity<List<BranchResDto>> listBranches(){
        return ResponseEntity.ok(branchservice.listBranches());
    }

    @PostMapping
    public ResponseEntity<BranchResDto> createBranch(@RequestBody @Valid BranchDto branchDto){
        return ResponseEntity.ok(branchservice.createBranch(branchDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BranchResDto> findBranchById(@PathVariable Long id){
        return ResponseEntity.ok(branchservice.findBranchById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBranchById(@PathVariable Long id){
        branchservice.deleteBranchById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BranchResDto> updateBranch(@PathVariable Long id, @RequestBody @Valid  BranchDto branchDto) {
        return ResponseEntity.ok(branchservice.updateBranch(id, branchDto));
    }

    @GetMapping("/{id}/departments")
    public ResponseEntity<BranchWithDepartmentsDto> findDepartmentsOfBranch(@PathVariable Long id){
        return ResponseEntity.ok(branchservice.findDepartmentsOfBranch(id));
    }
}
