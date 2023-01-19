package com.gedalias.securityjwt.security.api;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainResource {
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @GetMapping("/main")
    public String main() {
        return "Somente admins podem acessar essa página";
    }
}
