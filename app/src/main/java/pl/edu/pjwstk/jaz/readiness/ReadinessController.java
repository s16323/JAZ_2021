package pl.edu.pjwstk.jaz.readiness;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

//Zasób, który mówi czy aplikacja jest 'ready'

@RestController                         //kontroler staje się rejestrowanym ziarnem. Framework wie, że to jest kontroler dostarczający jakies funkcjonalności.
public class ReadinessController {

    @PersistenceContext
    private EntityManager em;    //pośrednik do bazy danych

    @GetMapping("is-ready")              //endpoint "is-ready" dla GET
    @Transactional                          //metoda bedzie wykonywana w transakcji - będzie mogła mieć wpływ na baze danych
    public void isReady(){                  //jeżeli się wykona poprawnie to znaczy, że w DB poprawnie się zapisało
        var entity = new Test1Entity();
        entity.setName("sdavsda");
        em.persist(entity);
    }

/*    @GetMapping("is-ready")         //endpoint "is-ready" dla GET
    public void isReady(){
        //throw new UnsupportedOperationException("xxxxxxx");  //teraz test powinien nie przejść
    }

    @PersistenceContext
    private final EntityManager em;    //pośrednik do bazy danych
    public ReadinessController(EntityManager em) {
        this.em = em;
    }*/
}