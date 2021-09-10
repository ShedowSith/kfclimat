package ru.rahimyanov_aleks.KFClimat.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Data
@Entity
@Table(name = "CLIENTS")
public class Client {
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

    @Column(name = "TELEPHONE")
    private String telephone;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private Collection<Application> applications;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id.equals(client.id) && surname.equals(client.surname) && name.equals(client.name) && Objects.equals(patronymic, client.patronymic) && email.equals(client.email) && password.equals(client.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, name, patronymic, email, password);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", applications=" + applications +
                '}';
    }
}
