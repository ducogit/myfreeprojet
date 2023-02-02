package com.example.logement10.Repository;

import com.example.logement10.Entity.Bloc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BlocRepository extends JpaRepository<Bloc,Long> {
    @Query("select bloc from Bloc bloc where bloc.nomBloc like :mot")
    public List<Bloc> trouvezListeBlocContientMotCle(@Param("mot") String motCle);
    List<Bloc> findAllByNomBloc(String nomBLoc);
    List<Bloc> findAllByTypeBloc(String typeBloc);
    Bloc findBlocByNomBloc(String nomBloc);


}
