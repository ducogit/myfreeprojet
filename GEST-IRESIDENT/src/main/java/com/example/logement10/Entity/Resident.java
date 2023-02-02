package com.example.logement10.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Resident implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResident;
    private String nomResident;
    private String prenomResident;
    private String sexeResident;
    private Date dateNaisseResident;
    private String lieuNaisseReaident;
    private String adresseResident;
    private String nationaliteResident;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String photoResident;
    private String filiereResident;
    private String serieBaccResident;
    private String anneBaccResident;
    private Date dateResident;
    @OneToMany(mappedBy = "resident",fetch = FetchType.LAZY)
    Collection<Insription> insription;
    @OneToMany(mappedBy = "resident",fetch = FetchType.LAZY)
    Collection<Tranfert> tranfert;

    public Resident(Long idResident, String nomResident, String prenomResident, String sexeResident, Date dateNaisseResident, String lieuNaisseReaident, String adresseResident, String nationaliteResident, String photoResident, String filiereResident, String serieBaccResident, String anneBaccResident, Date dateResident) {
        this.idResident = idResident;
        this.nomResident = nomResident;
        this.prenomResident = prenomResident;
        this.sexeResident = sexeResident;
        this.dateNaisseResident = dateNaisseResident;
        this.lieuNaisseReaident = lieuNaisseReaident;
        this.adresseResident = adresseResident;
        this.nationaliteResident = nationaliteResident;
        this.photoResident = photoResident;
        this.filiereResident = filiereResident;
        this.serieBaccResident = serieBaccResident;
        this.anneBaccResident = anneBaccResident;
        this.dateResident = dateResident;
    }

    public Resident(String nomResident, String sexeResident, Date dateNaisseResident, String lieuNaisseReaident, String adresseResident, String nationaliteResident, String photoResident, String filiereResident, String serieBaccResident, String anneBaccResident, Date dateResident) {
        this.nomResident = nomResident;
        this.sexeResident = sexeResident;
        this.dateNaisseResident = dateNaisseResident;
        this.lieuNaisseReaident = lieuNaisseReaident;
        this.adresseResident = adresseResident;
        this.nationaliteResident = nationaliteResident;
        this.photoResident = photoResident;
        this.filiereResident = filiereResident;
        this.serieBaccResident = serieBaccResident;
        this.anneBaccResident = anneBaccResident;
        this.dateResident = dateResident;
    }

    public Resident(String nomResident, String prenomResident, String sexeResident, Date dateNaisseResident, String lieuNaisseReaident, String adresseResident, String nationaliteResident, String photoResident, String filiereResident, String serieBaccResident, String anneBaccResident, Date dateResident) {
        this.nomResident = nomResident;
        this.prenomResident = prenomResident;
        this.sexeResident = sexeResident;
        this.dateNaisseResident = dateNaisseResident;
        this.lieuNaisseReaident = lieuNaisseReaident;
        this.adresseResident = adresseResident;
        this.nationaliteResident = nationaliteResident;
        this.photoResident = photoResident;
        this.filiereResident = filiereResident;
        this.serieBaccResident = serieBaccResident;
        this.anneBaccResident = anneBaccResident;
        this.dateResident = dateResident;
    }

    public Resident(String nomResident, String prenomResident, String sexeResident, Date dateNaisseResident, String lieuNaisseReaident, String adresseResident, String nationaliteResident, String photoResident, String filiereResident, String serieBaccResident, String anneBaccResident, Date dateResident, Collection<Insription> insription, Collection<Tranfert> tranfert) {
        this.nomResident = nomResident;
        this.prenomResident = prenomResident;
        this.sexeResident = sexeResident;
        this.dateNaisseResident = dateNaisseResident;
        this.lieuNaisseReaident = lieuNaisseReaident;
        this.adresseResident = adresseResident;
        this.nationaliteResident = nationaliteResident;
        this.photoResident = photoResident;
        this.filiereResident = filiereResident;
        this.serieBaccResident = serieBaccResident;
        this.anneBaccResident = anneBaccResident;
        this.dateResident = dateResident;
        this.insription = insription;
        this.tranfert = tranfert;
    }
}
