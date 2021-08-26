package ru.rahimyanov_aleks.KFClimat.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "RESPONSES")
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "PRICE", nullable = false)
    private Integer price;

    @Column(name = "DATE", nullable = false)
    private Date date;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "MASTER_ID")
    private Master master;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "APPLICATION_AD")
    private Application application;

}
