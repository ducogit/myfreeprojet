package com.example.logement10.Repository;

import com.example.logement10.Entity.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Chambrerepository extends JpaRepository<Chambre,Long> {
    Chambre findChambreByNumeroChambre(int numChambre);
    List<Chambre> findAllByNomBlocOrderByNumeroChambreAsc(String nomBloc);
    Chambre findChambreByNumeroChambreAndNomBloc(int nbrChambre, String nomBloc);
    List<Chambre> findAllByNbrPlaceLibre(int nbr);
}
