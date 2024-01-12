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
@Table(name = "edifici")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Edificio {

    @Id
    @GeneratedValue
    private long id;

    private String buildingName;

    private String address;

    private String city;


    public Edificio(String buildingName, String address, String city) {
        this.buildingName = buildingName;
        this.address = address;
        this.city = city;
    }
}
