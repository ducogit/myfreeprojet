package com.example.logement10.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity @Data
@AllArgsConstructor @NoArgsConstructor
public class Employer implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmployer;
    private String nomEmployer;
    private String prenomEmployer;
    private String fonctionEmployer;
    private String cinEmployer;
    private String emailEmployer;
    private String pseudoEmployer;
    private String motPassEmployer;
    @OneToMany(mappedBy = "employer")
    Collection<Insription> insription;
    @OneToMany(mappedBy = "employer")
    Collection<Tranfert> tranferts;
    private Date dateEmployer;

    public Employer(String nomEmployer, String fonctionEmployer, String cinEmployer, String emailEmployer, String pseudoEmployer, String motPassEmployer, Date dateEmployer) {
        this.nomEmployer = nomEmployer;
        this.fonctionEmployer = fonctionEmployer;
        this.cinEmployer = cinEmployer;
        this.emailEmployer = emailEmployer;
        this.pseudoEmployer = pseudoEmployer;
        this.motPassEmployer = motPassEmployer;
        this.dateEmployer = dateEmployer;
    }

    public Employer(String nomEmployer, String prenomEmployer, String fonctionEmployer, String cinEmployer, String emailEmployer, String pseudoEmployer, String motPassEmployer, Date dateEmployer) {
        this.nomEmployer = nomEmployer;
        this.prenomEmployer = prenomEmployer;
        this.fonctionEmployer = fonctionEmployer;
        this.cinEmployer = cinEmployer;
        this.emailEmployer = emailEmployer;
        this.pseudoEmployer = pseudoEmployer;
        this.motPassEmployer = motPassEmployer;
        this.dateEmployer = dateEmployer;
    }

    public Employer(String nomEmployer, String prenomEmployer, String fonctionEmployer, String cinEmployer, String emailEmployer, String pseudoEmployer, String motPassEmployer, Collection<Insription> insription, Collection<Tranfert> tranferts, Date dateEmployer) {
        this.nomEmployer = nomEmployer;
        this.prenomEmployer = prenomEmployer;
        this.fonctionEmployer = fonctionEmployer;
        this.cinEmployer = cinEmployer;
        this.emailEmployer = emailEmployer;
        this.pseudoEmployer = pseudoEmployer;
        this.motPassEmployer = motPassEmployer;
        this.insription = insription;
        this.tranferts = tranferts;
        this.dateEmployer = dateEmployer;
    }
}
