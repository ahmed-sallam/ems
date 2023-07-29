package com.techpeak.ems.company.repositories;

import com.techpeak.ems.company.entities.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface BranchRepository extends JpaRepository<Branch, Long> {

    @Query("SELECT b FROM Branch b JOIN FETCH b.departments WHERE b.id = (:id)")
    public Branch findByIdAndFetchDepartments(@Param("id") Long id);
}
