package com.example.logement10.Repository;

import com.example.logement10.Entity.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepository extends JpaRepository<Employer,Long> {
    Employer findEmployerByPseudoEmployer(String pseudo);
}
