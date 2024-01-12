package ygorgarofalo.SpringBeU2w1Project.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ygorgarofalo.SpringBeU2w1Project.Exceptions.ItemNotFoundExc;
import ygorgarofalo.SpringBeU2w1Project.entities.Utente;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;


    public void saveUser(Utente utente) {

        if (utente != null) {

            userDAO.save(utente);
            System.out.println("Utente aggiunto al database.");
        } else {
            System.err.println("Errore nell'aggiunta dell'utente al database.");
        }
    }


    public Utente finById(long id) {

        return userDAO.findById(id).orElseThrow(() -> new ItemNotFoundExc(id));
    }

}
