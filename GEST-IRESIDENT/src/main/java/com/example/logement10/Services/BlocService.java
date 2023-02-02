package com.example.logement10.Services;

import com.example.logement10.Entity.Bloc;
import com.example.logement10.Repository.BlocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlocService {
    @Autowired BlocRepository blocRepository;

    public boolean enregistrerBloc(Bloc bloc){
        blocRepository.save(bloc);
        return true;
    }

    public List<Bloc> tousLesBloc(){
        return blocRepository.findAll(Sort.by("dateBloc").descending());
    }

}
