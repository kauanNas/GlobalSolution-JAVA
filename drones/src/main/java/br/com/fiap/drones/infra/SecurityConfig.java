package br.com.fiap.drones.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       return http
               .cors()
               .and()
               .csrf().disable()
               .authorizeHttpRequests()
               .anyRequest()
               .authenticated()
               .and()
               .httpBasic()
               .and().build();
    }


    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder password = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser("kauan")
                .password(password.encode("fiapsecurity"))
                .roles("drone-admin")
                .and()
                .withUser("felipe")
                .password(password.encode("fiapsecurity"))
                .roles("telemetria-reader")
                .and()
                .withUser("vitor")
                .password(password.encode("fiapsecurity"))
                .roles("drone-seed");
    }
}