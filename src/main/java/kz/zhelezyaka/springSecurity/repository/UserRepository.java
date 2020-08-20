package kz.zhelezyaka.springSecurity.repository;

import kz.zhelezyaka.springSecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
