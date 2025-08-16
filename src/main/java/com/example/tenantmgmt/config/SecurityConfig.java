package com.example.tenantmgmt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                    .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
                    .csrf(csrf -> csrf.disable())
                    .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.ALWAYS));




        return http.build();
    }
}