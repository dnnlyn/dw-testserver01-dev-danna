package com.dw.dwtestserver01.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
  @Bean
  CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(Arrays.asList("http://localhost:3002", "http://localhost:3002/"));
    configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PATCH"));
    configuration.setAllowedHeaders(List.of("*"));
    configuration.setExposedHeaders(List.of("Cookie"));
    configuration.setAllowCredentials(true);
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .cors(Customizer.withDefaults())
        .csrf().disable()
        .headers(headers -> headers
            .contentTypeOptions(contentTypeOptionsConfig ->
                contentTypeOptionsConfig.disable()))
        .formLogin().disable()
        .httpBasic().disable()
        .sessionManagement()
        .sessionFixation().changeSessionId()
        .and()
        .exceptionHandling()

        .and()
        .authorizeHttpRequests(authorize -> authorize
                .anyRequest().permitAll()

        );
    return http.build();
  }
}
