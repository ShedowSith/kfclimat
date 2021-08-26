package ru.rahimyanov_aleks.KFClimat.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "_USERS")
public class User {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ROLE_ID")
    private Role role;
}
