package ru.rahimyanov_aleks.KFClimat.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity(name = "Types")
public class Type {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @OneToMany(mappedBy = "type", fetch = FetchType.LAZY)
    private Collection<Application> applications;
}
