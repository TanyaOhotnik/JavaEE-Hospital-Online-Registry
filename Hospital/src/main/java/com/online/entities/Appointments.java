package com.online.entities;

import javax.persistence.*;

/**
 * Created by Tanya Ohotnik on 20.10.2016.
 */
@Entity
@Table(name = "appointments")
@NamedQuery(name = "Appointments.getAll", query = "SELECT i FROM Appointments i")
public class Appointments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private long id;

    @Column(name = "report")
    private String report;

    @Column(name = "data")
    private String data;

    @Column(name = "time")
    private String time;
//    @OneToMany(mappedBy = "specialization", targetEntity = Doctor.class, fetch = FetchType.LAZY)
    @ManyToOne(targetEntity = Profile.class, fetch=FetchType.LAZY)
    @JoinColumn(name="doctor_id")
    private Profile doctor;

    @ManyToOne(targetEntity = Profile.class, fetch=FetchType.LAZY)
    @JoinColumn(name="patient_id", nullable = true)
    private Profile patient;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Profile getDoctor() {
        return doctor;
    }

    public void setDoctor(Profile doctor) {
        this.doctor = doctor;
    }

    public Profile getPatient() {
        return patient;
    }

    public void setPatient(Profile patient) {
        this.patient = patient;
    }
}
