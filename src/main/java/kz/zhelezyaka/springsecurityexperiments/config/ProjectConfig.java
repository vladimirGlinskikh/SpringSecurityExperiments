package kz.zhelezyaka.springsecurityexperiments.config;

import kz.zhelezyaka.springsecurityexperiments.model.User;
import kz.zhelezyaka.springsecurityexperiments.services.InMemoryUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class ProjectConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails userDetails = new User("Vladimir", "123", "read");
        UserDetails userDetails1 = new User("Svetlana", "124", "write");
        List<UserDetails> users = List.of(userDetails, userDetails1);
        return new InMemoryUserDetailsService(users);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
