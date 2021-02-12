package pl.edu.pjwstk.jaz;

import org.springframework.http.HttpStatus;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//Przyklad filtra - działa przed określonymi zapytaniami jako dodatkowa logika

//@WebFilter("*")     // * czyli zadziała dla wszystkich zapytań
public class ExampleFilter extends HttpFilter {

    private final UserSession userSession;

    public ExampleFilter(UserSession userSession){
        this.userSession = userSession;
    }

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        if(isUserLogged() || isSiteAllowed(request)){          //tutaj warunki zadziałania filtru i co zrobić z użytkownikiem jeżeli spełnione
            chain.doFilter(request, response);        //czyli pozwala przejść do następnego filtra w łańcuchu
//            response.sendRedirect("/api/login");    //przekierowanie do strony logowania
                                                        // Zostanie wysłany code 302 (redirect) - W headerze 'location' będzie przekazany adres przekierowania
        }
        else{
            response.setStatus(HttpStatus.UNAUTHORIZED.value());    //nie pozwól na dostęp do zasobu. Code 401
                                                                    //każde zapytanie powinno mieć odpowiedź
        }
        //super.doFilter(request, response, chain);
    }

    private boolean isSiteAllowed(HttpServletRequest request){
        return false;
//        return request.getContextPath().equals(....) || request.getContextPath().equals(....);
    }

    private boolean isUserLogged(){
        return userSession.isLoggedIn();
    }
}
