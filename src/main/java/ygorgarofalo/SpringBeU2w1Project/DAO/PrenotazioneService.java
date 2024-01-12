package ygorgarofalo.SpringBeU2w1Project.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ygorgarofalo.SpringBeU2w1Project.Exceptions.ItemNotFoundExc;
import ygorgarofalo.SpringBeU2w1Project.entities.Postazione;
import ygorgarofalo.SpringBeU2w1Project.entities.Prenotazione;
import ygorgarofalo.SpringBeU2w1Project.entities.Utente;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneDAO prenotazioneDAO;


    //Il metodo save della prenotazione richiama il metodo cerca prenotazione per postazione e data della prenotazione dao
    //Se il metodo torna una lista con degli elementi allora significa che la prenotazione non è disponibile per quella postazione
    // e per la data indicata

    //Inoltre il metodo save richiama anche il metodo findByUtenteAndDataPrenotazione che torna una lista di prenotazioni
    //filtrate per utente e data di prenotazione qualora ce ne fossero, in questo modo controllo se un utente specifico abbia gia
    //una prenotazione salvata in una data specifica

    //nel costrutto if / else if gestisco le varie casistiche
    public void savePrenotazione(Prenotazione prenotazione) {
        LocalDate dataPrenotazione = prenotazione.getDataPrenotazione();
        Postazione postazione = prenotazione.getPostazione();
        Utente user = prenotazione.getUtente();


        List<Prenotazione> prenotazioniEsistenti = prenotazioneDAO.findByPostazioneAndDataPrenotazione(postazione, dataPrenotazione);

        List<Prenotazione> prenotazioniEsistentiPerStessaDataEdUser = prenotazioneDAO.findByUtenteAndDataPrenotazione(user, dataPrenotazione);


        // se non è vuota ovvero che ci sono prenotazioni con una specifica postazione e una specifica data, genera un errore
        if (!prenotazioniEsistenti.isEmpty()) {
            System.out.println("Errore, prenotazione non disponibile per la data e la postazione indicate");
        } else if (!prenotazioniEsistentiPerStessaDataEdUser.isEmpty()) {

            System.out.println("Errore, l'utente ha gia una prenotazione salvata in data " + prenotazione.getDataPrenotazione());
        } else {
            prenotazioneDAO.save(prenotazione);
            System.out.println("Prenotazione salvata, data prenotazione: " + dataPrenotazione + ", Luogo: " + postazione.getEdificio());
        }
    }


    public Prenotazione findById(long id) {

        return prenotazioneDAO.findById(id).orElseThrow(() -> new ItemNotFoundExc(id));
    }


    public void findPrenotazioneByUtente(Utente user) {
        List<Prenotazione> found = prenotazioneDAO.findByUtente(user);

        if (found.isEmpty()) {
            System.out.println("Nessuna prenotazione trovata per l'utente selezionato.");

        } else {
            System.out.println("Lista prenotazione per l'utente: " + user.getFullname());
            found.forEach(System.out::println);
        }
    }


}
