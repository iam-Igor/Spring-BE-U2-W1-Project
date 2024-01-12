package ygorgarofalo.SpringBeU2w1Project.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "utenti")
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Utente {

    @Id
    @GeneratedValue
    private long id;

    private String username;

    private String fullname;

    private String email;


    public Utente(String username, String fullname, String email) {
        this.username = username;
        this.fullname = fullname;
        this.email = email;
    }
}
