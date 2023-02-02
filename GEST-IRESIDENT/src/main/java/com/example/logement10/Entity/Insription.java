package com.example.logement10.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Insription implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInscription;
    private String anneeInscription;
    private String statuInscription;
    private int numeroChambre;
    private String nomBloc;
    private String nomResident;
    private String nomEmployer;
    @ManyToOne @JoinColumn(name = "idResident")
    private Resident resident;
    @ManyToOne @JoinColumn(name = "idChambre")
    private Chambre chambre;
    @ManyToOne @JoinColumn(name = "idEmployer")
    private Employer employer;
    private Date dateInscription;

    public Insription(String anneeInscription, String statuInscription, int numeroChambre, String nomBloc, String nomResident, String nomEmployer, Date dateInscription) {
        this.anneeInscription = anneeInscription;
        this.statuInscription = statuInscription;
        this.numeroChambre = numeroChambre;
        this.nomBloc = nomBloc;
        this.nomResident = nomResident;
        this.nomEmployer = nomEmployer;
        this.dateInscription = dateInscription;
    }

    public Insription(Long idInscription, String anneeInscription, String statuInscription, int numeroChambre, String nomBloc, String nomResident, String nomEmployer, Date dateInscription) {
        this.idInscription = idInscription;
        this.anneeInscription = anneeInscription;
        this.statuInscription = statuInscription;
        this.numeroChambre = numeroChambre;
        this.nomBloc = nomBloc;
        this.nomResident = nomResident;
        this.nomEmployer = nomEmployer;
        this.dateInscription = dateInscription;
    }

    public Insription(String anneeInscription, String statuInscription, Resident resident, Chambre chambre, Employer employer, Date dateInscription) {
        this.anneeInscription = anneeInscription;
        this.statuInscription = statuInscription;
        this.resident = resident;
        this.chambre = chambre;
        this.employer = employer;
        this.dateInscription = dateInscription;
    }

    public Insription(String anneeInscription, String statuInscription, int numeroChambre, String nomBloc, String nomResident, String nomEmployer, Resident resident, Chambre chambre, Employer employer, Date dateInscription) {
        this.anneeInscription = anneeInscription;
        this.statuInscription = statuInscription;
        this.numeroChambre = numeroChambre;
        this.nomBloc = nomBloc;
        this.nomResident = nomResident;
        this.nomEmployer = nomEmployer;
        this.resident = resident;
        this.chambre = chambre;
        this.employer = employer;
        this.dateInscription = dateInscription;
    }
}
