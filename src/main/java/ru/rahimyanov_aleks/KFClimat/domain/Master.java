package ru.rahimyanov_aleks.KFClimat.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

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

    @Column(name = "EMAIL", unique = true, nullable = false)
    private String email;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "BRIGADE", unique = true, nullable = false)
    private String brigade;

    @Column(name = "DESCRIPTIONS")
    private String descriptions;

    @Column(name = "TELEPHONE")
    private String telephone;

    @OneToMany(mappedBy = "master", fetch = FetchType.EAGER)
    private Collection<Response> responses;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Master master = (Master) o;
        return id.equals(master.id) && surname.equals(master.surname) && name.equals(master.name) && Objects.equals(patronymic, master.patronymic) && email.equals(master.email) && password.equals(master.password) && brigade.equals(master.brigade) && Objects.equals(descriptions, master.descriptions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, name, patronymic, email, password, brigade, descriptions);
    }

    @Override
    public String toString() {
        return "Master{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", brigade='" + brigade + '\'' +
                ", descriptions='" + descriptions + '\'' +
                ", responses=" + responses +
                '}';
    }
}
