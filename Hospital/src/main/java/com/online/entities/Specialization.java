package com.online.entities;

import javax.persistence.*;

/**
 * Created by Tanya Ohotnik on 20.10.2016.
 */
@Entity
@Table(name = "specialization")
@NamedQuery(name = "Specialization.getAll", query = "SELECT i FROM Specialization i")
public class Specialization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "specialization_id")
    private long id;

    @Column(name = "name")
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String report) {
        this.name = report;
    }
}
