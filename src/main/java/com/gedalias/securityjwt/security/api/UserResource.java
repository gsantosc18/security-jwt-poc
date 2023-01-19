package com.gedalias.securityjwt.security.api;

import com.gedalias.securityjwt.security.domain.Role;
import com.gedalias.securityjwt.security.domain.User;
import com.gedalias.securityjwt.security.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserResource {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return ResponseEntity.status(CREATED).body(userService.saveUser(user));
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        return ResponseEntity.status(CREATED).body(userService.saveRole(role));
    }

    @PostMapping("/role/addToUser")
    public ResponseEntity saveRole(@RequestBody RoleUserForm roleUserForm) {
        userService.addRoleToUser(roleUserForm.getUsername(), roleUserForm.getRoleName());
        return ResponseEntity.ok().build();
    }

    @Data
    class RoleUserForm {
        private String username;
        private String roleName;
    }
}
