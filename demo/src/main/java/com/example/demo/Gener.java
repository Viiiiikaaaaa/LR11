package com.example.demo;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(
        name = "geners"
)
public class Gener {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id"
    )
    private int id;
    @Column(
            name = "name"
    )
    private String name;
    @OneToMany(
            mappedBy = "gener"
    )
    private List<Film> geners;

    public Gener() {
    }

    public String toString() {
        return "Жанр {id=" + this.id + ", название ='" + this.name + "'}";
    }
}