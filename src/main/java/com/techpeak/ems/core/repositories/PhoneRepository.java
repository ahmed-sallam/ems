package com.techpeak.ems.core.repositories;

import com.techpeak.ems.core.entities.AddressEntity;
import com.techpeak.ems.core.entities.PhoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PhoneRepository extends JpaRepository<PhoneEntity, Long> {

}
