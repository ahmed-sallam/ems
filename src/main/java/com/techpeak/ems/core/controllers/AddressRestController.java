package com.techpeak.ems.core.controllers;

import com.techpeak.ems.company.dto.BranchDto;
import com.techpeak.ems.company.dto.BranchResDto;
import com.techpeak.ems.company.dto.BranchWithDepartmentsDto;
import com.techpeak.ems.core.dto.AddressDto;
import com.techpeak.ems.core.dto.AddressResDto;
import com.techpeak.ems.core.services.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static java.util.Optional.ofNullable;

@RestController()
@RequestMapping("/api/v1/addresses")
@RequiredArgsConstructor
public class AddressRestController {

    private final AddressService addressService;

    @GetMapping
    public ResponseEntity<List<AddressResDto>> listAddresses(){
        List<AddressResDto> results = addressService.listAddresses();
        return ResponseEntity.of(ofNullable(results));
    }

    @PostMapping
    public ResponseEntity<AddressResDto> createAddress(@RequestBody @Valid AddressDto addressDto){
//        if(addressDto.getBranch() == null){
//            System.out.println("llll"+ addressDto.getBranch());
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//            // todo: recfactor after adding the Employee
//        }
        AddressResDto result = addressService.createAddress(addressDto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressResDto> findAddressById(@PathVariable Long id){
        AddressResDto result;
        try {
         result = addressService.findAddressById(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAddressById(@PathVariable Long id){
        try {

        addressService.deleteAddressById(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AddressResDto> updateAddress(@PathVariable Long id,
                                              @RequestBody @Valid AddressDto addressDto) {
        AddressResDto result;
        try {
            result = addressService.updateAddress(id, addressDto);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(result);
    }

}
