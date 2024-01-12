package ygorgarofalo.SpringBeU2w1Project.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ygorgarofalo.SpringBeU2w1Project.Exceptions.ItemNotFoundExc;
import ygorgarofalo.SpringBeU2w1Project.entities.Postazione;
import ygorgarofalo.SpringBeU2w1Project.entities.TipoPostazione;

import java.util.List;
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

    public void findPostazioneByTipoAndCity(TipoPostazione tipoPostazione, String city) {
        List<Postazione> postazioneList = postazioneDAO.findByTipoPostazioneAndCitta(tipoPostazione, city);

        if (postazioneList.isEmpty()) {
            System.out.println("Nessuna postazione per i criteri specificati");
        } else {
            System.out.println("LISTA POSTAZIONI DISPONIBILI PER I CRITERI SELEZIONATI");
            postazioneList.forEach(System.out::println);
        }


    }
}
