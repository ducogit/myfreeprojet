package com.example.logement10.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Bloc implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBloc;
    private String codeBloc;
    private String nomBloc;
    private String typeBloc;
    private int nbrChambreBloc;
    private int capaciteChambre;
    private Date dateBloc;
    private String nomResidence;


    public Bloc(String codeBloc, String nomBloc, String typeBloc, int nbrChambreBloc, int capaciteChambre, Date dateBloc, String nomResidence) {
        this.codeBloc = codeBloc;
        this.nomBloc = nomBloc;
        this.typeBloc = typeBloc;
        this.nbrChambreBloc = nbrChambreBloc;
        this.capaciteChambre = capaciteChambre;
        this.dateBloc = dateBloc;
        this.nomResidence = nomResidence;
    }
}
