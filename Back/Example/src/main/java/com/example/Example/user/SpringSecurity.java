package com.example.Example.user;

/*import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@SpringBootApplication
public class SpringSecurity extends WebSecurityConfigurerAdapter {
   public static void main(String[] args){
        SpringApplication.run(SpringSecurity.class,args);
    }

    @Override
    protected void configure (AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}admin")
                .roles("admin");
    }

    @Override
    protected void configure (HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }
}*/
