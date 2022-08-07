package one.digitalinnovation.gof.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/swagger-ui").authenticated()
                .antMatchers("/").permitAll()
                .antMatchers(HttpMethod.GET,"/clientes").hasAnyRole("MANAGERS")
                .antMatchers(HttpMethod.PUT,"/clientes").hasAnyRole("MANAGERS")
                .antMatchers(HttpMethod.DELETE,"/clientes").hasAnyRole("MANAGERS")
                .antMatchers(HttpMethod.POST,"/clientes").hasAnyRole("MANAGERS")
                .anyRequest().authenticated().and().formLogin();;
    }

}
