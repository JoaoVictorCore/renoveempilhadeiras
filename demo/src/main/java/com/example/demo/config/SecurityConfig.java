package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;


@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        // Permite acesso público à home, url de envio e arquivos estáticos (css, imagens)
                        .requestMatchers("/", "/enviar", "/css/**", "/img/**", "/js/**").permitAll()
                        .anyRequest().authenticated() // Qualquer outra coisa exige login
                )
                // Desabilita login padrão do Spring (não precisamos de login de usuário aqui)
                .formLogin((form) -> form.disable())
                .logout((logout) -> logout.permitAll());

        return http.build();
    }
}