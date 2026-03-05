package ies.alcores.api_lol.repository;

import ies.alcores.api_lol.model.Campeon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampeonRepository extends JpaRepository<Campeon, Long> {

    @Query("SELECT c FROM Campeon c")
    List<Campeon> consultarTodoElPlantel();

    @Query("SELECT c FROM Campeon c WHERE c.region.nombre = :nombreDeLaZona")
    List<Campeon> buscarPorNombreRegion(@Param("nombreDeLaZona") String zona);

    @Query("SELECT c FROM Campeon c WHERE c.linea = :posicionEnMapa")
    List<Campeon> buscarPorPosicion(@Param("posicionEnMapa") String posicion);

}
