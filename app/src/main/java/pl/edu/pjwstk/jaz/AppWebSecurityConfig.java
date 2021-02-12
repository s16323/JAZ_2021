package pl.edu.pjwstk.jaz;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppWebSecurityConfig {

    //Tworzymy ten obiekt w ten sposób bo:
    //Filtr rejestruje się w inny sposób niż inne (normalne) obiekty (@Component)
    //Żeby framework wiedział, ze to filtr
    //Obiekty @Component to zwykłe obiekty kontenerowe - nie są używane do samej konfiguracji filtrowania w Springu
    //Tu więc rejestrujemy 'exampleFilter' jako filtr

    //metoda tworząca
    @Bean       //rejestruje obiekt w kontenerze
    public FilterRegistrationBean<ExampleFilter> exampleFilter(UserSession userSession){        //Filtr potrzebuje sesji, więc będziemy ją wstrzykiwać (userSession)
        FilterRegistrationBean<ExampleFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new ExampleFilter(userSession)); //nowa instancja naszego filtru
        registrationBean.addUrlPatterns("/auth0/*");                //scieżki, na których ten filtr będzie aktywny
                                                                    //niech cały nie-springowy mechanizm logowania i autoryzacji działa tylko na testowym /auth0
        return registrationBean;
    }
}
