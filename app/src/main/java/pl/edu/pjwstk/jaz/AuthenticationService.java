package pl.edu.pjwstk.jaz;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component //lub @Service - jednoznaczne w tym wypadku
public class AuthenticationService {

    public boolean login(String username, String password){

        //kod do zalogowania się


        //jest zalogowany

        //var user = new User(Collections.emptySet());

        //Modyfikowanie statycznej wartości w thread localu, uwaga!
//        SecurityContextHolder.getContext().setAuthentication(new AppAuthentication(user));    //gotowy mechanizm Spring, więcej na ćwiczenia_7 7:00

        return false;
    }

}
