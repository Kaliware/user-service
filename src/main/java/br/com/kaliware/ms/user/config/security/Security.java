package br.com.kaliware.ms.user.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class Security {

  private static final String[] SWAGGER_LIST = {
      "/swagger-ui/**",
      "/v3/api-docs/**",
      "/swagger-resources/**"
  };

  @Bean
  protected SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
    security.csrf(AbstractHttpConfigurer::disable)
        .headers(HeadersConfigurer::disable)
        .authorizeHttpRequests(auth -> {
          auth.requestMatchers("/**").permitAll();
        }).httpBasic(withDefaults());
    return security.build();
  }

  /*@Bean
  protected SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
    security.csrf(AbstractHttpConfigurer::disable)
        .headers(HeadersConfigurer::disable)
        .authorizeHttpRequests(auth -> {
          auth.requestMatchers(SWAGGER_LIST).permitAll()
              .requestMatchers("/h2-console/**").permitAll()
              .requestMatchers("/user/create").permitAll();
          auth.anyRequest().authenticated();
        }).httpBasic(withDefaults());
    return security.build();
  }*/

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
