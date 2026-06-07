package com.akash.portfolio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth -> auth

                        .requestMatchers(
                                "/",
                                "/login",
                                "/contact",
                                "/download-resume",
                                "/project/**",
                                "/css/**",
                                "/js/**",
                                "/images/**",
                                "/uploads/**"
                        ).permitAll()

                        .requestMatchers(
                                "/admin",
                                "/projects",
                                "/messages",
                                "/add-project",
                                "/edit-project/**",
                                "/delete-project/**",
                                "/delete-message/**"
                        ).authenticated()

                        .anyRequest().authenticated()
                )

                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/admin", true)
                        .permitAll()
                )

                .logout(logout -> logout
                        .logoutSuccessUrl("/")
                        .permitAll()
                );

        return http.build();
    }
}