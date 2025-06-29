package com.password_validator_bff.password_validator.config;

import org.junit.jupiter.api.Test;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import static org.assertj.core.api.Assertions.assertThat;

class SecurityConfigTest {

    private final SecurityConfig securityConfig = new SecurityConfig();

    @Test
    void corsFilter_shouldUseProvidedCorsConfigurationSource() {
        CorsConfigurationSource source = securityConfig.corsConfigurationSource();
        CorsFilter filter = securityConfig.corsFilter(source);

        assertThat(filter).isNotNull();
    }
}