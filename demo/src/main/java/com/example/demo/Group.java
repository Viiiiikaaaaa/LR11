package com.example.demo;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(
        name = "groups"
)
public class Group {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id"
    )
    private int id;
    @Column(
            name = "number"
    )
    private int number;
    @ManyToMany
    @JoinTable(
            name = "groups_films",
            joinColumns = {@JoinColumn(
                    name = "group_id"
            )},
            inverseJoinColumns = {@JoinColumn(
                    name = "film_id"
            )}
    )
    private List<Film> films;

    public Group() {
    }

    public String toString() {
        return "Group{id=" + this.id + ", количество =" + this.number + "}";
    }
}
