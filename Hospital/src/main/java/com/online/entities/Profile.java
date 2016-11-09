package com.online.entities;

import javax.persistence.*;

/**
 * Created by Tanya Ohotnik on 20.10.2016.
 */
@Entity
@Table(name = "profile")
@NamedQuery(name = "Profile.getAll", query = "SELECT i FROM Profile i")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "sex")
    private String sex;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "cabinet", nullable = true)
    private String cabinet;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

//    @OneToOne(cascade = CascadeType.ALL)
    @ManyToOne(targetEntity = Post.class, cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

//    @OneToOne(cascade = CascadeType.ALL)
    @ManyToOne(targetEntity = Specialization.class, cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name = "specialization_id")
    private Specialization specialization;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCabinet() {
        return cabinet;
    }

    public void setCabinet(String cabinet) {
        this.cabinet = cabinet;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }
}
