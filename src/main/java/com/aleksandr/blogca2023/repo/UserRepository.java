package com.aleksandr.blogca2023.repo;

import com.aleksandr.blogca2023.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}