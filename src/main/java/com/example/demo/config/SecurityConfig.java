package com.example.demo.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Value("${spring.security.oauth2.client.registration.google.client-id:}")
    private String googleClientId;

    @Value("${spring.security.oauth2.client.registration.google.client-secret:}")
    private String googleClientSecret;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        System.out.println("✅ Food Fiesta Security Configuration is being loaded!");
        http
            .csrf(csrf -> csrf.disable())
            .headers(headers -> headers.frameOptions(frame -> frame.sameOrigin()))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/home", "/login", "/register", "/adminLogin", "/userLogin", "/products", "/location", "/about", "/api/health").permitAll()
                .requestMatchers("/css/**", "/JavaScript/**", "/Images/**").permitAll()
                .requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui.html", "/h2-console/**").permitAll()
                .requestMatchers("/dashboard", "/product/search", "/product/order", "/product/back").hasAnyRole("USER", "ADMIN")
                .requestMatchers(
                        "/admin/**",
                        "/addAdmin", "/addingAdmin", "/updateAdmin/**", "/updatingAdmin/**", "/deleteAdmin/**",
                        "/addProduct", "/addingProduct", "/updateProduct/**", "/updatingProduct/**", "/deleteProduct/**",
                        "/addUser", "/addingUser", "/updateUser/**", "/updatingUser/**", "/deleteUser/**"
                ).hasRole("ADMIN")
                .anyRequest().authenticated()
            );

        if (isGoogleOAuthEnabled()) {
            http.oauth2Login(oauth2 -> oauth2
                    .loginPage("/login")
                    .defaultSuccessUrl("/oauth2/success", true)
            );
        }

        http.logout(logout -> logout
                .logoutSuccessUrl("/home")
                .permitAll()
        );
        return http.build();
    }

    private boolean isGoogleOAuthEnabled() {
        return googleClientId != null && !googleClientId.isBlank()
                && googleClientSecret != null && !googleClientSecret.isBlank();
    }

    @ControllerAdvice
    static class OAuthModelAttributes {
        @Value("${spring.security.oauth2.client.registration.google.client-id:}")
        private String googleClientId;

        @Value("${spring.security.oauth2.client.registration.google.client-secret:}")
        private String googleClientSecret;

        @ModelAttribute
        void addOAuthFlags(Model model) {
            boolean enabled = googleClientId != null && !googleClientId.isBlank()
                    && googleClientSecret != null && !googleClientSecret.isBlank();
            model.addAttribute("googleOAuthEnabled", enabled);
        }
    }
}
