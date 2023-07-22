package com.techpeak.ems.company.repositories;

import com.techpeak.ems.company.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {


}
