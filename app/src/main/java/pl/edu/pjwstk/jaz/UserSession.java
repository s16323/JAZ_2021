package pl.edu.pjwstk.jaz;


import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

//Ziarno sesyjne
//Tu będą informacje dostępne w czasie sesji, wiele requestów będzie mogło z nich skorzystać
//Trzeba wymysleć co tu powinn być

@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)   //istnieje w kontekście sesji; proxyMode - żeby można było wstrzykiwac obiekty sesyjne do kontekstu aplikacji (albo krótjo żyjące w długo żyjący)
//proxyMode bo stosujemy wzorzec proxy. Istnieje jedna instancja filtra. (więcej: cwiczenia_6 30:00)
//Jeżeli wstrzykujemy zależności między kontekstami (krótki -> długi, czyli, np. aplikacja -> request) - proxyMode jest potrzebny (inaczej nie)
@Component          //czyli (w Springu) obiekt zarządzany przez kontener. Obiekt automatycznie się utworzy.
                    //sposób rejestrowania obiektu. Bez tego nie dałoby się go wstrzyknąć.
public class UserSession {

    public boolean isUserLoggedIn = false;
    public String userLoggedInAs = "";


    public boolean isLoggedIn(){
        if (userLoggedInAs.equals("")){
            return false;
        }
        else
            return  true;
    }
    //tutaj jakaś zmienna informacja,
    //która pozwoli określić czy użytkownik jest zalogowany czy nie

    //metody do zarządzania ta informacją

}