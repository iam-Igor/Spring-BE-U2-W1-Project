package ygorgarofalo.SpringBeU2w1Project.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ygorgarofalo.SpringBeU2w1Project.entities.Postazione;
import ygorgarofalo.SpringBeU2w1Project.entities.Prenotazione;
import ygorgarofalo.SpringBeU2w1Project.entities.Utente;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrenotazioneDAO extends JpaRepository<Prenotazione, Long> {


    //Questo metodo cerca in tutte le prenotazioni filtrate per postazione e data di prenotazione e ne ritorna una lista
    // se i criteri di ricerca vengono soddisfatti
    List<Prenotazione> findByPostazioneAndDataPrenotazione(Postazione postazione, LocalDate dataPrenotaz);


    //Questo metodo filtra le prenotazioni che corrispondono ad un certo user e ad una certa data di prenotazione
    // e ne ritorna una lista nel caso in cui vi sono elemnti nel db con questa query, altrimenti torna una lista vuota
    List<Prenotazione> findByUtenteAndDataPrenotazione(Utente utente, LocalDate dataPrenotaz);

}
