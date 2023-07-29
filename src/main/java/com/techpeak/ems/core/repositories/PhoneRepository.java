package com.techpeak.ems.core.repositories;

import com.techpeak.ems.core.models.Phone;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PhoneRepository extends JpaRepository<Phone, Long> {

}
