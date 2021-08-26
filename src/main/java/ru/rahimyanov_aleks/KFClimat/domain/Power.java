package ru.rahimyanov_aleks.KFClimat.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity(name = "Powers")
public class Power {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "POWER", nullable = false)
    private Short power;

    @OneToMany(mappedBy = "power", fetch = FetchType.LAZY)
    private Collection<Application> applications;
}
