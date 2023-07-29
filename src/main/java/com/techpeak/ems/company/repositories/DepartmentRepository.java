package com.techpeak.ems.company.repositories;

import com.techpeak.ems.company.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DepartmentRepository extends JpaRepository<Department, Long> {


}
