package com.gedalias.securityjwt.security.repository;

import com.gedalias.securityjwt.security.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
