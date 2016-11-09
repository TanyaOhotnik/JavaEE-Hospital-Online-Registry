package com.online.dao;

import com.online.entities.Appointments;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Tanya Ohotnik on 25.09.2016.
 */
public class DAOappointments {
    private  EntityManager em = Persistence.createEntityManagerFactory("labEntityManager").createEntityManager();

    public Appointments add(Appointments appointment){
        em.getTransaction().begin();
        Appointments appointmentFromDB = em.merge(appointment);
        em.getTransaction().commit();
        return appointmentFromDB;
    }

    public void delete(long id){
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public Appointments get(long id){
        return em.find(Appointments.class, id);
    }

    public void update(Appointments appointment){
        em.getTransaction().begin();
        em.merge(appointment);
        em.getTransaction().commit();
    }


    public List<Appointments> getAll(){
        TypedQuery<Appointments> namedQuery = em.createNamedQuery("Appointments.getAll", Appointments.class);
        return namedQuery.getResultList();
    }
}
