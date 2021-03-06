package be.hogent.giveaday.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.Ordered;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by bart on 20/05/2017.
 */
@Configuration
@EnableWebMvc
@EnableJpaRepositories
@ComponentScan("be.hogent.giveaday.controller")
@Import({ SecurityConfig.class })
public class WebConfig extends WebMvcConfigurerAdapter  {
    @Bean(name = "authDataSource")
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource =
                new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(
                "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        driverManagerDataSource.setUrl(
                "jdbc:sqlserver://194.78.14.12\\\\SQLEXPRESS:10433;databaseName=GoedBezigDB");
        driverManagerDataSource.setUsername("GoedBezigDB");
        driverManagerDataSource.setPassword("Een goede admin deelt nooit zijn wachtwoord!");
        return driverManagerDataSource;
    }
}
