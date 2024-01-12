package ygorgarofalo.SpringBeU2w1Project.DAO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ygorgarofalo.SpringBeU2w1Project.Exceptions.ItemNotFoundExc;
import ygorgarofalo.SpringBeU2w1Project.entities.Edificio;

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

}
