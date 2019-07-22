package dev;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
        // désactivation de la protection CSRF
        // non utilisée dans le cadre d'une Web API
        .csrf().disable()
        .authorizeRequests()
        // un GET /me n'est pas soumise à authentification
        .antMatchers(HttpMethod.GET, "/me").permitAll()
        
        // un POST /auth n'est pas soumi à authentification
        .antMatchers(HttpMethod.POST, "/me").permitAll()
        
        // accès à la console h2 sans authentification
        .antMatchers("/h2-console/**").permitAll()

        // Les autres requêtes sont soumises à authentification
        .anyRequest().authenticated()
        
        // accès à la console h2 sans authentification
        .and().headers().frameOptions().disable();
    }
  }