package ygorgarofalo.SpringBeU2w1Project.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "prenotazioni")
@NoArgsConstructor
@Getter
public class Prenotazione {


    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "postazione_id")
    private Postazione postazione;

    private LocalDate dataPrenotazione;


    public Prenotazione(Utente utente, Postazione postazione, LocalDate dataPrenotazione) {
        this.utente = utente;
        this.postazione = postazione;
        this.dataPrenotazione = dataPrenotazione;
    }

    public Utente setUtente(Utente utente) {
        return this.utente = utente;
    }

    public Postazione setPostazione(Postazione postazione) {
        return this.postazione = postazione;
    }

    public void setDataPrenotazione(LocalDate dataPrenotazione) {
        this.dataPrenotazione = dataPrenotazione;
    }
}
