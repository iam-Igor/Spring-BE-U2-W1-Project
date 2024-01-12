package ygorgarofalo.SpringBeU2w1Project.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ygorgarofalo.SpringBeU2w1Project.entities.Edificio;

import java.util.List;

@Repository
public interface EdificioDAO extends JpaRepository<Edificio, Long> {


    List<Edificio> findByCity(String city);

    Edificio findByBuildingName(String name);

}
