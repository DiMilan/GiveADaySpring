package be.hogent.giveaday.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                // enable in memory based authentication with a user named
                // "user" and "admin"
                .inMemoryAuthentication()
                .withUser("user").password("user").roles("USER").and()
                .withUser("admin").password("admin").roles("USER", "ADMIN");
    }
    /*
     OR
     @Autowired
     public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
     auth
     .inMemoryAuthentication()
     .withUser("user").password("user").roles("USER").and()
     .withUser("admin").password("admin").roles("USER", "ADMIN");
     }
     */

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin().defaultSuccessUrl("/hello");
        http.csrf().disable();
        http
                .authorizeRequests()
                .antMatchers("/*").hasRole("USER");
    }
}

