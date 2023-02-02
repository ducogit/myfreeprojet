package com.example.logement10.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Tranfert implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTransfert;
    private Date dateTransfert;
    private String motifTransfert;
    private int numChambreOrigine;
    private int numChambreDestination;
    @ManyToOne @JoinColumn(name = "idResident")
    private Resident resident;
    @ManyToOne @JoinColumn(name = "idChambreOrigine")
    private Chambre chambreOr;
    @ManyToOne @JoinColumn(name = "idChambreDestination")
    private Chambre chambreDes;
    @ManyToOne @JoinColumn(name = "idEmployer")
    private Employer employer;

    public Tranfert(Date dateTransfert, String motifTransfert, int numChambreOrigine, int numChambreDestination, Resident resident, Chambre chambreOr, Chambre chambreDes, Employer employer) {
        this.dateTransfert = dateTransfert;
        this.motifTransfert = motifTransfert;
        this.numChambreOrigine = numChambreOrigine;
        this.numChambreDestination = numChambreDestination;
        this.resident = resident;
        this.chambreOr = chambreOr;
        this.chambreDes = chambreDes;
        this.employer = employer;
    }
}
