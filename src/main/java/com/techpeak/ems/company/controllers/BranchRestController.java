package com.techpeak.ems.company.controllers;

import com.techpeak.ems.company.dto.BranchDto;
import com.techpeak.ems.company.dto.BranchResDto;
import com.techpeak.ems.company.dto.BranchWithDepartmentsDto;
import com.techpeak.ems.company.services.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static java.util.Optional.ofNullable;

@RestController()
@RequestMapping("/api/v1/branches")
@RequiredArgsConstructor
public class BranchRestController {

    private final BranchService branchservice;

    @GetMapping
    public ResponseEntity<List<BranchResDto>> listBranches(){
        List<BranchResDto> results = branchservice.listBranches();
        return ResponseEntity.of(ofNullable(results));
    }

    @PostMapping
    public ResponseEntity<BranchResDto> createBranch(@RequestBody Map<String
                    , BranchDto> dto){
        BranchDto branchDto = dto.get("branch");
        BranchResDto result = branchservice.createBranch(branchDto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BranchResDto> findBranchById(@PathVariable Long id){
        BranchResDto result;
        try {
         result = branchservice.findBranchById(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBranchById(@PathVariable Long id){
        try {

        branchservice.deleteBranchById(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BranchResDto> updateBranch(@PathVariable Long id, @RequestBody Map<String
            , BranchDto> dto) {
        BranchDto branchDto = dto.get("branch");
        BranchResDto result;
        try {
            result = branchservice.updateBranch(id, branchDto);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}/departments")
    public ResponseEntity<BranchWithDepartmentsDto> findDepartmentsOfBranch(@PathVariable Long id){

        BranchWithDepartmentsDto result;
        try {
            result = branchservice.findDepartmentsOfBranch(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(result);
    }
}
