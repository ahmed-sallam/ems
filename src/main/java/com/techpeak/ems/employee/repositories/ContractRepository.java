package com.techpeak.ems.employee.repositories;

import com.techpeak.ems.employee.models.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Long> {
}
