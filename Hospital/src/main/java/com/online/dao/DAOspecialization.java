package com.online.dao;

import com.online.entities.Specialization;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Tanya Ohotnik on 25.09.2016.
 */
public class DAOspecialization {
    private  EntityManager em = Persistence.createEntityManagerFactory("labEntityManager").createEntityManager();

    public Specialization add(Specialization specialization){
        em.getTransaction().begin();
        Specialization specializationFromDB = em.merge(specialization);
        em.getTransaction().commit();
        return specializationFromDB;
    }

    public void delete(long id){
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public Specialization get(long id){
        return em.find(Specialization.class, id);
    }

    public void update(Specialization specialization){
        em.getTransaction().begin();
        em.merge(specialization);
        em.getTransaction().commit();
    }


    public List<Specialization> getAll(){
        TypedQuery<Specialization> namedQuery = em.createNamedQuery("Specialization.getAll", Specialization.class);
        return namedQuery.getResultList();
    }
}
