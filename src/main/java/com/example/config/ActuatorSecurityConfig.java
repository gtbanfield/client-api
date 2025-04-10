package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.XXssProtectionHeaderWriter;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableWebSecurity
public class ActuatorSecurityConfig {


	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
  @Bean
  public SecurityFilterChain configure(HttpSecurity http) throws Exception {
    http.headers(headers ->
            headers
            	   .httpStrictTransportSecurity(hstsConfig -> {
            	   	hstsConfig.includeSubDomains(true);
            	   	hstsConfig.maxAgeInSeconds(350000);
		   })
		   .xssProtection(
			  xss -> xss.headerValue(XXssProtectionHeaderWriter.HeaderValue.ENABLED_MODE_BLOCK)
		   ).contentSecurityPolicy(
			  cps -> cps.policyDirectives("script-src 'self'")
		   ));
    return http.csrf(AbstractHttpConfigurer::disable).build();
  }
}
