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
public class Residence implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResidence;
    private String nomResidence;
    private String adresseResidence;
    private int capaciteResidence;
    private String nomDirecteur;
    private String prenomDirecteur;
    private String contactDirecteur;
    private Date dateResidence;

    public Residence(String nomResidence, String adresseResidence, int capaciteResidence, String nomDirecteur, String contactDirecteur, Date dateResidence) {
        this.nomResidence = nomResidence;
        this.adresseResidence = adresseResidence;
        this.capaciteResidence = capaciteResidence;
        this.nomDirecteur = nomDirecteur;
        this.contactDirecteur = contactDirecteur;
        this.dateResidence = dateResidence;
    }

    public Residence(String nomResidence, String adresseResidence, int capaciteResidence, String nomDirecteur, String prenomDirecteur, String contactDirecteur, Date dateResidence) {
        this.nomResidence = nomResidence;
        this.adresseResidence = adresseResidence;
        this.capaciteResidence = capaciteResidence;
        this.nomDirecteur = nomDirecteur;
        this.prenomDirecteur = prenomDirecteur;
        this.contactDirecteur = contactDirecteur;
        this.dateResidence = dateResidence;
    }
}
