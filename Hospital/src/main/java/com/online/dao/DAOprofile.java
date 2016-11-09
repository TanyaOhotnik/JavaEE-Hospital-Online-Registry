package com.online.dao;

import com.online.entities.Profile;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Tanya Ohotnik on 25.09.2016.
 */
public class DAOprofile {
    private  EntityManager em = Persistence.createEntityManagerFactory("labEntityManager").createEntityManager();

    public Profile add(Profile profile){
        em.getTransaction().begin();
        Profile profileFromDB = em.merge(profile);
        em.getTransaction().commit();
        return profileFromDB;
    }

    public void delete(long id){
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public Profile get(long id){
        return em.find(Profile.class, id);
    }

    public void update(Profile profile){
        em.getTransaction().begin();
        em.merge(profile);
        em.getTransaction().commit();
    }


    public List<Profile> getAll(){
        TypedQuery<Profile> namedQuery = em.createNamedQuery("Profile.getAll", Profile.class);
        return namedQuery.getResultList();
    }
}
