package com.gedalias.securityjwt.security.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity @Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = ROLE_SEQUENCE)
    @SequenceGenerator(name = ROLE_SEQUENCE,sequenceName = ROLE_SEQUENCE)
    private Long id;
    private String name;

    @Transient
    private final String ROLE_SEQUENCE = "role_sq";
}
