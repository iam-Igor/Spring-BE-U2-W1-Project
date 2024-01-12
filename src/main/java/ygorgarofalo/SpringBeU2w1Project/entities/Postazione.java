package ygorgarofalo.SpringBeU2w1Project.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Table(name = "postazioni")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Postazione {

    @Id
    @GeneratedValue
    private UUID id;

    private String description;

    private TipoPostazione tipoPostazione;

    private int numMaxOccupanti;

    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;


    public Postazione(String description, TipoPostazione tipoPostazione, int numMaxOccupanti, Edificio edificio) {
        this.description = description;
        this.tipoPostazione = tipoPostazione;
        this.numMaxOccupanti = numMaxOccupanti;
        this.edificio = edificio;
    }
}
