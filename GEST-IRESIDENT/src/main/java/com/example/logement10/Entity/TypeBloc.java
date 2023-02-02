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
public class TypeBloc implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idType;
    private String codeTypeBloc;
    private String residenceType;
    private String nomType;
    private String descriptionType;
    private Date dateTypeBloc;

    public TypeBloc(String codeTypeBloc, String residenceType, String nomType, String descriptionType) {
        this.codeTypeBloc = codeTypeBloc;
        this.residenceType = residenceType;
        this.nomType = nomType;
        this.descriptionType = descriptionType;
    }

    public TypeBloc(String codeTypeBloc, String residenceType, String nomType, String descriptionType, Date dateTypeBloc) {
        this.codeTypeBloc = codeTypeBloc;
        this.residenceType = residenceType;
        this.nomType = nomType;
        this.descriptionType = descriptionType;
        this.dateTypeBloc = dateTypeBloc;
    }
}
