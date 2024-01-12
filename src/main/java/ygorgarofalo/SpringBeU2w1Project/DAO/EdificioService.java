package ygorgarofalo.SpringBeU2w1Project.DAO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ygorgarofalo.SpringBeU2w1Project.Exceptions.ItemNotFoundExc;
import ygorgarofalo.SpringBeU2w1Project.entities.Edificio;

import java.util.List;

@Service
public class EdificioService {

    @Autowired
    private EdificioDAO edificioDAO;


    public void saveEdificio(Edificio edificio) {

        if (edificio != null) {

            edificioDAO.save(edificio);
            System.out.println("Edificio salvato nel database.");
        } else {
            System.err.println("Errore nel salvataggio dell'edificio");
        }
    }


    public Edificio findById(long id) {

        return edificioDAO.findById(id).orElseThrow(() -> new ItemNotFoundExc(id));
    }


    public void findByCityName(String city) {

        List<Edificio> foundList = edificioDAO.findByCity(city);

        if (foundList.isEmpty()) {
            System.out.println("Nessuna edificio presente nella città selezionata");
        } else {
            System.out.println("Edifici trovati per la città: " + city);
            foundList.forEach(System.out::println);
        }


    }


    public void findByNomeEdificio(String name) {

        Edificio found = edificioDAO.findByBuildingName(name);

        if (found != null) {
            System.out.println("Edificio trovato con il nome: " + name);
            System.out.println(found);
        } else {
            System.out.println("Nessun edificio trovato con il nome indicato.");
        }
    }
}
