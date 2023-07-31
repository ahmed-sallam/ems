package com.techpeak.ems.employee.controllers;


import com.techpeak.ems.employee.dto.PersonalDto;
import com.techpeak.ems.employee.dto.PersonalResDto;
import com.techpeak.ems.employee.services.PersonalService;
import com.techpeak.ems.exceptions.BadRequestException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/personals")
@RequiredArgsConstructor
public class PersonalController {
    private final PersonalService personalService;

    @PostMapping
    public ResponseEntity<PersonalResDto> createPersonal(@RequestBody @Valid PersonalDto personalDto){
        return ResponseEntity.ok(personalService.createPersonal(personalDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonalResDto> findPersonal(@PathVariable Long id){
        return ResponseEntity.ok(personalService.findPersonal(id));
    }

    @GetMapping
    public ResponseEntity<List<PersonalResDto>>  listPersonals(){
        return ResponseEntity.ok(personalService.listPersonals());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonalResDto> updatePersonal(@PathVariable Long id,
                                                         @RequestBody @Valid PersonalDto personalDto){
        if(!id.equals(personalDto.getId()) ){
            throw new BadRequestException("Invalid personal ID");
        }
        return ResponseEntity.ok(personalService.updatePersonal(personalDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePersonal(@PathVariable Long id){
        personalService.deletePersonal(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
