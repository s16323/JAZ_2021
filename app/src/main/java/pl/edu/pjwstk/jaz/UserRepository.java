package pl.edu.pjwstk.jaz;


import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

//@Repository - czyli to będzie jedyna lista w systemie, która zawiera użytkowników i z niej tylko system ma korzystać
@Repository //@Component //@Service //bo ma istnieć w kontekście aplikacji - te adnotacje rejestrują obiekt w springowym kontenerze
public class UserRepository {

    private Map<String, User> userMap = new HashMap<>();

    public void add(User user){
        //zaimplementować

        throw new UnsupportedOperationException("TODO");
    }

    public Optional<User> findByUsername(String username){
        //zaimplementować

        throw new UnsupportedOperationException("TODO");
    }
}
