package com.techpeak.ems.core.repositories;

import com.techpeak.ems.core.entities.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

}
