package org.example.springsecurity6.repositories;

import org.example.springsecurity6.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, String>{
    Optional<User> findUserByUsername(String username);
}
