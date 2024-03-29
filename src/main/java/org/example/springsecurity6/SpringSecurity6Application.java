package org.example.springsecurity6;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springsecurity6.emuns.RoleEnum;
import org.example.springsecurity6.entities.User;
import org.example.springsecurity6.repositories.IUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
@Slf4j
@SpringBootApplication
@AllArgsConstructor
public class SpringSecurity6Application implements CommandLineRunner {
    private final IUserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurity6Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.saveAll(
                List.of(
                        User.builder()
                                .username("user")
                                .password(passwordEncoder.encode("user"))
                                .role(RoleEnum.USER)
                                .build(),
                        User.builder()
                                .username("admin")
                                .password(passwordEncoder.encode("admin"))
                                .role(RoleEnum.ADMIN)
                                .build()
                ));
        log.info("Users added to the database");
        userRepository.findAll().forEach(user -> log.info(user.toString()));
    }
}
