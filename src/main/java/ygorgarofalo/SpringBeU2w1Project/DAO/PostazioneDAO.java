package ygorgarofalo.SpringBeU2w1Project.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ygorgarofalo.SpringBeU2w1Project.entities.Postazione;

import java.util.UUID;

@Repository
public interface PostazioneDAO extends JpaRepository<Postazione, UUID> {

    
}
