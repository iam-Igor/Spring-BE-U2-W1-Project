package ygorgarofalo.SpringBeU2w1Project.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ygorgarofalo.SpringBeU2w1Project.entities.Postazione;
import ygorgarofalo.SpringBeU2w1Project.entities.Prenotazione;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneDAO prenotazioneDAO;


    //Il metodo save della prenotazione richiama il metodo cerca prenotazione per postazione e data del prenotazione dao
    //Se il metodo torna una lista con degli elementi allora significa che la prenotazione non è disponibile per quella postazione
    // e per la data indicata, altrimenti salva la prenotazione.
    public void savePrenotazione(Prenotazione prenotazione) {
        LocalDate dataPrenotazione = prenotazione.getDataPrenotazione();
        Postazione postazione = prenotazione.getPostazione();

        List<Prenotazione> prenotazioniEsistenti = prenotazioneDAO.findByPostazioneAndDataPrenotazione(postazione, dataPrenotazione);

        // se non è vuota ovvero che ci sono prenotazioni con una specifica postazione e una specifica data, genera un errore
        if (!prenotazioniEsistenti.isEmpty()) {
            System.out.println("Errore, prenotazione non disponibile per la data e la postazione indicate");
        } else {
            prenotazioneDAO.save(prenotazione);
            System.out.println("Prenotazione salvata, data prenotazione: " + dataPrenotazione + ", Luogo: " + postazione.getEdificio());
        }
    }

}
