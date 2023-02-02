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
@Entity @Data
@AllArgsConstructor @NoArgsConstructor
public class Fonction implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFonction;
    private String codeFonction;
    private String nomFonction;
    private Date dateFonction;

    public Fonction(String codeFonction, String nomFonction, Date dateFonction) {
        this.codeFonction = codeFonction;
        this.nomFonction = nomFonction;
        this.dateFonction = dateFonction;
    }
}
