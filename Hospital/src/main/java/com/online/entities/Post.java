package com.online.entities;

import javax.persistence.*;

/**
 * Created by Tanya Ohotnik on 20.10.2016.
 */
@Entity
@Table(name = "post")
@NamedQuery(name = "Post.getAll", query = "SELECT i FROM Post i")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
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

    public void setName(String name) {
        this.name = name;
    }
}
