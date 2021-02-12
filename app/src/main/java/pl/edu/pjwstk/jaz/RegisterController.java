package pl.edu.pjwstk.jaz;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//Kontroler do rejestracji

public class RegisterController {
    @PostMapping("/register")
    public  void  register(@RequestBody RegisterRequest registerRequest){

        //obiekt utrzymujacy zarejestrowanych uzytkownikow

        //register user
    }
}
