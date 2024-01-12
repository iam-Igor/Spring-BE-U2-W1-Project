package ygorgarofalo.SpringBeU2w1Project.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ygorgarofalo.SpringBeU2w1Project.entities.Postazione;
import ygorgarofalo.SpringBeU2w1Project.entities.TipoPostazione;

import java.util.List;
import java.util.UUID;

@Repository
public interface PostazioneDAO extends JpaRepository<Postazione, UUID> {


    @Query("SELECT p FROM Postazione p WHERE p.tipoPostazione = :tipo AND p.edificio.city = :city")
    List<Postazione> findByTipoPostazioneAndCitta(@Param("tipo") TipoPostazione tipoPostazione, @Param("city") String city);


    List<Postazione> findByNumMaxOccupantiBetween(int min, int max);
}
