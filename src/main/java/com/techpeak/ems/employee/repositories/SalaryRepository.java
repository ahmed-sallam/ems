package com.techpeak.ems.employee.repositories;

import com.techpeak.ems.employee.models.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<Salary, Long> {
}
