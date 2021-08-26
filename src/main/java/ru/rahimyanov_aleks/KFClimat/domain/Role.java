package ru.rahimyanov_aleks.KFClimat.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity(name = "Roles")
public class Role {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
    private Collection<User> users;
}
