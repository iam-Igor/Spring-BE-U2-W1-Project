package ygorgarofalo.SpringBeU2w1Project.Runners;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ygorgarofalo.SpringBeU2w1Project.DAO.EdificioService;
import ygorgarofalo.SpringBeU2w1Project.DAO.UserService;
import ygorgarofalo.SpringBeU2w1Project.entities.Edificio;
import ygorgarofalo.SpringBeU2w1Project.entities.Utente;

import java.util.Locale;

@Component
public class MainRunner implements CommandLineRunner {

    @Autowired
    UserService userService;

    @Autowired
    EdificioService edificioService;

    @Override
    public void run(String... args) throws Exception {

        Faker faker = new Faker(Locale.ITALIAN);

        Utente u1 = new Utente(faker.name().username(), faker.name().fullName(), faker.internet().emailAddress());
        Utente u2 = new Utente(faker.name().username(), faker.name().fullName(), faker.internet().emailAddress());
        Utente u3 = new Utente(faker.name().username(), faker.name().fullName(), faker.internet().emailAddress());
        Utente u4 = new Utente(faker.name().username(), faker.name().fullName(), faker.internet().emailAddress());
        Utente u5 = new Utente(faker.name().username(), faker.name().fullName(), faker.internet().emailAddress());


        Edificio e1 = new Edificio(faker.company().name(), faker.address().fullAddress(), faker.address().city());
        Edificio e2 = new Edificio(faker.company().name(), faker.address().fullAddress(), faker.address().city());
        Edificio e3 = new Edificio(faker.company().name(), faker.address().fullAddress(), faker.address().city());

      /*  userService.saveUser(u1);
        userService.saveUser(u2);
        userService.saveUser(u3);
        userService.saveUser(u4);
        userService.saveUser(u5); */


       /*  edificioService.saveEdificio(e1);
        edificioService.saveEdificio(e2);
        edificioService.saveEdificio(e3);*/

        
    }
}
