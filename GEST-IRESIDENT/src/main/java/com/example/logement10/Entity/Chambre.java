package com.example.logement10.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Chambre implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChambre;
    private int numeroChambre;
    private int capaciteChambre;
    private int nbrPlaceLibre;
    private String nomBloc;
    @OneToMany(mappedBy = "chambre")
    Collection<Insription> insription;
    @OneToMany(mappedBy = "chambreOr")
    Collection<Tranfert> tranfertOr;
    @OneToMany(mappedBy = "chambreDes")
    Collection<Tranfert> tranfertDes;
    private Date dateChambre;

    public Chambre(Long idChambre, int numeroChambre, int capaciteChambre, int nbrPlaceLibre, String nomBloc, Date dateChambre) {
        this.idChambre = idChambre;
        this.numeroChambre = numeroChambre;
        this.capaciteChambre = capaciteChambre;
        this.nbrPlaceLibre = nbrPlaceLibre;
        this.nomBloc = nomBloc;
        this.dateChambre = dateChambre;
    }

    public Chambre(int numeroChambre, int capaciteChambre, int nbrPlaceLibre, String nomBloc, Date dateChambre) {
        this.numeroChambre = numeroChambre;
        this.capaciteChambre = capaciteChambre;
        this.nbrPlaceLibre = nbrPlaceLibre;
        this.nomBloc = nomBloc;
        this.dateChambre = dateChambre;
    }

    public Chambre(int numeroChambre, int capaciteChambre, int nbrPlaceLibre, Date dateChambre) {
        this.numeroChambre = numeroChambre;
        this.capaciteChambre = capaciteChambre;
        this.nbrPlaceLibre = nbrPlaceLibre;
        this.dateChambre = dateChambre;
    }

    public Chambre(int numeroChambre, int capaciteChambre, int nbrPlaceLibre, Collection<Insription> insription, Date dateChambre) {
        this.numeroChambre = numeroChambre;
        this.capaciteChambre = capaciteChambre;
        this.nbrPlaceLibre = nbrPlaceLibre;
        this.insription = insription;
        this.dateChambre = dateChambre;
    }

    public Chambre(int numeroChambre, int capaciteChambre, int nbrPlaceLibre, Collection<Insription> insription, Collection<Tranfert> tranfertOr, Collection<Tranfert> tranfertDes, Date dateChambre) {
        this.numeroChambre = numeroChambre;
        this.capaciteChambre = capaciteChambre;
        this.nbrPlaceLibre = nbrPlaceLibre;
        this.insription = insription;
        this.tranfertOr = tranfertOr;
        this.tranfertDes = tranfertDes;
        this.dateChambre = dateChambre;
    }
}
