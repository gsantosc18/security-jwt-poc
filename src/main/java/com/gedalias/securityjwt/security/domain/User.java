package com.gedalias.securityjwt.security.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collection;

import static jakarta.persistence.FetchType.EAGER;
import static jakarta.persistence.GenerationType.SEQUENCE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity @Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = USER_SEQUENCE)
    @SequenceGenerator(name = USER_SEQUENCE,sequenceName = USER_SEQUENCE)
    private Long id;
    private String name;
    private String username;
    @ToString.Exclude
    private String password;

    @ManyToMany(fetch = EAGER)
    private Collection<Role> roles = new ArrayList<>();

    @Transient
    private final String USER_SEQUENCE = "user_sq";
}
