package com.techpeak.ems.employee.repositories;

import com.techpeak.ems.employee.models.Personal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalRepository extends JpaRepository<Personal, Long> {
}
