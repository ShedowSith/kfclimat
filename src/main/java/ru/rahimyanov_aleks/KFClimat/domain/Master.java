package ru.rahimyanov_aleks.KFClimat.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity(name = "MASTERS")
public class Master {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "SURNAME", nullable = false)
    private String surname;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "PATRONYMIC")
    private String patronymic;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "PASSWORD", unique = true, nullable = false)
    private String password;

    @Column(name = "BRIGADE", unique = true, nullable = false)
    private String brigade;

    @Column(name = "DESCRIPTIONS")
    private String descriptions;

    @OneToMany(mappedBy = "master", fetch = FetchType.EAGER)
    private Collection<Response> responses;
}
