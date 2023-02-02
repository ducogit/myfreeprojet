package com.example.logement10.Repository;

import com.example.logement10.Entity.Resident;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResidentRepository extends JpaRepository<Resident,Long> {
}

