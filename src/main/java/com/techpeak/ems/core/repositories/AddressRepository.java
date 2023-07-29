package com.techpeak.ems.core.repositories;

import com.techpeak.ems.core.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AddressRepository extends JpaRepository<Address, Long> {

}
