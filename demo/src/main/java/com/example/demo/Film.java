package com.example.demo;

import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(
        name = "films"
)
public class Film {
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
            name = "slogan"
    )
    private String slogan;
    @Transient
    private String rang;
    @OneToOne
    @JoinColumn(
            name = "info_id"
    )
    private FilmInfo info;
    @ManyToOne
    @JoinColumn(
            name = "gener_id"
    )
    private Gener gener;
    @ManyToMany
    @JoinTable(
            name = "groups_films",
            joinColumns = {@JoinColumn(
                    name = "film_id"
            )},
            inverseJoinColumns = {@JoinColumn(
                    name = "film_id"
            )}
    )
    private List<Group> groups;

    public String toString() {
        return "Film{id=" + this.id + ", Название ='" + this.name + "', слоган =" + this.slogan + "}";
    }

    public Film(String name, String slogan) {
        this.name = name;
        this.slogan = slogan;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getSlogan() {
        return this.slogan;
    }

    public String getRang() {
        return this.rang;
    }

    public FilmInfo getInfo() {
        return this.info;
    }

    public Gener getGener() {
        return this.gener;
    }

    public List<Group> getGroups() {
        return this.groups;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public void setRang(String rang) {
        this.rang = rang;
    }

    public void setInfo(FilmInfo info) {
        this.info = info;
    }

    public void setGener(Gener gener) {
        this.gener = gener;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } if (o == null || getClass() != o.getClass()) {
            return false;
        } else {
            Film film = (Film) o;
            return id == film.id &&
                    Objects.equals(name, film.name) &&
                    Objects.equals(rang, film.rang) &&
                    Objects.equals(info, film.info) &&
                    Objects.equals(gener, film.gener) &&
                    Objects.equals(groups, film.groups);
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof Film;
    }

    public int hashCode() {
        int PRIME = 31;
        int result = 1;
        result = result * PRIME + this.getId();
        result = result * PRIME + (getSlogan() == null ? 0 : getSlogan().hashCode());
        result = result * PRIME + (getName() == null ? 0 : getName().hashCode());
        result = result * PRIME + (getRang() == null ? 0 : getRang().hashCode());
        result = result * PRIME + (getInfo() == null ? 0 : getInfo().hashCode());
        result = result * PRIME + (getGener() == null ? 0 : getGener().hashCode());
        result = result * PRIME + (getGroups() == null ? 0 : getGroups().hashCode());
        return result;
    }

    public Film() {
    }
}