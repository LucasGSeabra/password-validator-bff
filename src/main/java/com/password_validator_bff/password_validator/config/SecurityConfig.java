package com.password_validator_bff.password_validator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

/**
 * Configuração de segurança da aplicação com Spring Security.
 *
 * Configura CORS, OAuth2 Resource Server e endpoints protegidos.
 *
 * @author Sistema de Validação de Senhas
 * @version 1.0
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Configura CORS para permitir requisições do frontend Angular.
     *
     * @return configuração CORS para toda a aplicação
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();

        // Permite requisições do frontend Angular
        config.setAllowedOrigins(List.of("http://localhost:4200"));

        // Métodos HTTP permitidos
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        // Headers permitidos nas requisições
        config.setAllowedHeaders(List.of("Authorization", "Cache-Control", "Content-Type"));

        // Permite envio de credenciais (cookies, headers de autorização)
        config.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return source;
    }

    /**
     * Cria filtro CORS baseado na configuração.
     *
     * @param corsConfigurationSource configuração CORS
     * @return filtro CORS configurado
     */
    @Bean
    public CorsFilter corsFilter(CorsConfigurationSource corsConfigurationSource) {
        return new CorsFilter(corsConfigurationSource);
    }

    /**
     * Configura a cadeia de filtros de segurança da aplicação.
     *
     * Define autorização, CSRF e OAuth2 Resource Server para JWT.
     *
     * @param http configurador de segurança HTTP
     * @return cadeia de filtros de segurança
     * @throws Exception se houver erro na configuração
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf
                        // Desabilita CSRF para endpoint de token (necessário para POST)
                        .ignoringRequestMatchers("/auth/token")
                )
                .authorizeHttpRequests(auth -> auth
                        // Endpoint público para obtenção de tokens
                        .requestMatchers("/auth/token").permitAll()
                        // Endpoint protegido que requer autenticação JWT
                        .requestMatchers("/validar").authenticated()
                        // Nega acesso a qualquer outro endpoint não especificado
                        .anyRequest().denyAll()
                )
                // Configura OAuth2 Resource Server para validação de JWT
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(Customizer.withDefaults())
                );
        return http.build();
    }
}
