package com.aleksandr.blogca2023.repo;

import com.aleksandr.blogca2023.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}