package org.example.springsecurity6.security;

import lombok.RequiredArgsConstructor;
import org.example.springsecurity6.emuns.RoleEnum;
import org.example.springsecurity6.repositories.IUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserDetailsService userDetailsService(IUserRepository repository,BCryptPasswordEncoder passwordEncoder) {
        return (username -> repository.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username)));
    }
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorizeRequests ->{
            authorizeRequests.requestMatchers("/admin/**").hasAuthority(RoleEnum.ADMIN.name());
            authorizeRequests.anyRequest().permitAll();
        });
        http.formLogin(Customizer.withDefaults());
        return http.build();
    }
}
