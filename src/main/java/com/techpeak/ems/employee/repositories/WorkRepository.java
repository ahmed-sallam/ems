package com.techpeak.ems.employee.repositories;

import com.techpeak.ems.employee.models.Work;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkRepository extends JpaRepository<Work, Long> {
}
