package com.example.logement10.Services;

import com.example.logement10.Entity.Bloc;
import com.example.logement10.Entity.Chambre;
import com.example.logement10.Entity.Residence;
import com.example.logement10.Repository.BlocRepository;
import com.example.logement10.Repository.Chambrerepository;
import com.example.logement10.Repository.ResidenceRepository;
import com.example.logement10.Repository.ResidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResidenceService {
    @Autowired ResidenceRepository residenceRepository;
    @Autowired BlocRepository blocRepository;
    @Autowired Chambrerepository chambrerepository;

    public boolean enregistrerResidence(Residence residence){
        residenceRepository.save(residence);
        return true;
    }

    public List<Residence> selectionTousResidences(){
        List<Residence> residenceList = residenceRepository.findAll(Sort.by("dateResidence").descending());
        return residenceList;
    }

}
