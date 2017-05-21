package be.hogent.giveaday.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    DataSource authDataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(authDataSource)
                .usersByUsernameQuery(
                        "select username,password, enabled from javaWeb_users where username=?")
                .authoritiesByUsernameQuery(
                        "select username, role from javaWeb_user_roles where username=?");
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

        http.formLogin().loginPage("/login")
                .usernameParameter("username").passwordParameter("password")
                .and()
                .exceptionHandling().accessDeniedPage("/403");
        http.csrf().disable();
        http
                .authorizeRequests()
                .antMatchers("/*").hasRole("USER");
    }
}

