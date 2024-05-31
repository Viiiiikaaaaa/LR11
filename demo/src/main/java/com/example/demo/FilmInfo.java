package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(
        name = "film_info"
)
public class FilmInfo {
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
    @Column(
            name = "year"
    )
    private int year;
    @OneToOne(
            mappedBy = "info"
    )
    private Film film;

    public FilmInfo() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Film getFilm() {
        return this.film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public String toString() {
        return "FilmInfo{id=" + this.id + ", название ='" + this.name + "', год выпуска ='" + this.year + "'}";
    }
}
