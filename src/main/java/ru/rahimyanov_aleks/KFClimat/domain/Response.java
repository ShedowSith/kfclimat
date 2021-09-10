package ru.rahimyanov_aleks.KFClimat.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Data
@Entity(name = "RESPONSES")
@DynamicInsert
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "PRICE", nullable = false)
    private Integer price;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "DATE", nullable = false)
    private Date date;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "MASTER_ID")
    private Master master;

    @Column(name = "SELECTED", nullable = false, columnDefinition = "boolean default false")
    private boolean selected;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "APPLICATION_ID")
    private Application application;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Response response = (Response) o;
        return id.equals(response.id) && price.equals(response.price) && date.equals(response.date) && master.equals(response.master) && application.equals(response.application);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, date, master, application);
    }

    @Override
    public String toString() {
        return "Response{" +
                "id=" + id +
                ", price=" + price +
                ", date=" + date +
                ", master=" + master +
                ", application=" + application +
                '}';
    }
}
