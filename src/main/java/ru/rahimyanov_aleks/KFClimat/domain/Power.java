package ru.rahimyanov_aleks.KFClimat.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Power power1 = (Power) o;
        return id.equals(power1.id) && power.equals(power1.power);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, power);
    }
}
