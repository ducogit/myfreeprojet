package com.example.logement10.Services;

import com.example.logement10.Entity.Resident;
import com.example.logement10.Repository.ResidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResidentService {
    @Autowired ResidentRepository residentRepository;

    public List<Resident> selectionTousResident(){
        List<Resident> residentList = residentRepository.findAll();
        return residentList;
    }
}
