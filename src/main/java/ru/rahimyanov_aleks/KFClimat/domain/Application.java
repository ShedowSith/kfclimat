package ru.rahimyanov_aleks.KFClimat.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "APPLICATIONS")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CITY", nullable = false)
    private String city;

    @Column(name = "STREET", nullable = false)
    private String street;

    @Column(name = "HOUSE", nullable = false)
    private String house;

    @Column(name = "N_KV")
    private Long nKv;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "TYPE_ID")
    private Type type;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "POWER_ID")
    private Power power;
}
