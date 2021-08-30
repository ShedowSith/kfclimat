package ru.rahimyanov_aleks.KFClimat.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Application that = (Application) o;
        return id.equals(that.id) && city.equals(that.city) && street.equals(that.street) && house.equals(that.house) && Objects.equals(nKv, that.nKv) && Objects.equals(description, that.description) && client.equals(that.client) && type.equals(that.type) && power.equals(that.power);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city, street, house, nKv, description, client, type, power);
    }
}
