package pl.edu.pjwstk.jaz;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class AppWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("auth0/**").permitAll()    //przepuszczamy auth0 bo już jest osobny filtr (ExampleFilter) z poprzedniego zadania
                .anyRequest().authenticated()
                .and().csrf().disable();
    }
}
