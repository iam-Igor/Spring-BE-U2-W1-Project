package ygorgarofalo.SpringBeU2w1Project.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Entity
@Table(name = "postazioni")
@NoArgsConstructor
@Getter
@ToString
public class Postazione {

    @Id
    @GeneratedValue
    private UUID id;

    private String description;

    @Enumerated(EnumType.STRING)
    private TipoPostazione tipoPostazione;

    private int numMaxOccupanti;

    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;


    public Postazione(String description, TipoPostazione tipoPostazione, int numMaxOccupanti, Edificio edificio) {
        this.description = description;
        this.tipoPostazione = tipoPostazione;
        this.numMaxOccupanti = numMaxOccupanti;
        this.edificio = setEdificio(edificio);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTipoPostazione(TipoPostazione tipoPostazione) {
        this.tipoPostazione = tipoPostazione;
    }

    public void setNumMaxOccupanti(int numMaxOccupanti) {
        this.numMaxOccupanti = numMaxOccupanti;
    }

    public Edificio setEdificio(Edificio edificio) {
        return this.edificio = edificio;
    }
}
