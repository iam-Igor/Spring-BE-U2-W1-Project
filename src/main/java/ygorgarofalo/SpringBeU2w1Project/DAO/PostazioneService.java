package ygorgarofalo.SpringBeU2w1Project.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ygorgarofalo.SpringBeU2w1Project.Exceptions.ItemNotFoundExc;
import ygorgarofalo.SpringBeU2w1Project.entities.Postazione;

import java.util.UUID;

@Service
public class PostazioneService {

    @Autowired
    private PostazioneDAO postazioneDAO;

    public void savePostazione(Postazione postazione) {

        if (postazione != null) {

            postazioneDAO.save(postazione);
            System.out.println("Postazione aggiunta al database.");
        } else {
            System.err.println("Errore nell'aggiunta dela postazione al database.");
        }
    }


    public Postazione findById(String uuid) {

        UUID uuid1 = UUID.fromString(uuid);
        return postazioneDAO.findById(uuid1).orElseThrow(() -> new ItemNotFoundExc(uuid));
    }
}
