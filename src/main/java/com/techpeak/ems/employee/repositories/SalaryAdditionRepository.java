package com.techpeak.ems.employee.repositories;

import com.techpeak.ems.employee.models.SalaryAddition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryAdditionRepository extends JpaRepository<SalaryAddition, Long> {
}
