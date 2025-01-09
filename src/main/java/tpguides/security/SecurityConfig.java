package tpguides.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //noinspection removal
        return http
                .formLogin(httpForm -> {
                    httpForm.loginPage("/login").permitAll();
                })
                .authorizeHttpRequests(registry -> {
                    registry.requestMatchers("/register",
                            "/style.css",
                            "/Javascript/**",
                            "/img/**",
                            "/",
                            "/link",
                            "/results",
                            "/guide/*...",
                            "/write"
                    ).permitAll();
                    registry.requestMatchers("/api/guides", "/api/guides/search").permitAll();

                    // Zugriff auf die H2-Konsole erlauben
                    registry.requestMatchers("/h2-console/**").permitAll();
                })
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/h2-console/**") // CSRF für H2-Konsole deaktivieren
                        .ignoringRequestMatchers("/guide/{id}/**")
                        .ignoringRequestMatchers("/register")
                )

                .headers(headers -> headers.frameOptions().sameOrigin()) // Erlaube das Einbetten der Konsole in Iframes
                .build();
    }
}