package com.gedalias.securityjwt.security.repository;

import com.gedalias.securityjwt.security.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
