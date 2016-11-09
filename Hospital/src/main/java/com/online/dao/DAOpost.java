package com.online.dao;

import com.online.entities.Post;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Tanya Ohotnik on 25.09.2016.
 */
public class DAOpost {
    private  EntityManager em = Persistence.createEntityManagerFactory("labEntityManager").createEntityManager();

    public Post add(Post post){
        em.getTransaction().begin();
        Post postFromDB = em.merge(post);
        em.getTransaction().commit();
        return postFromDB;
    }

    public void delete(long id){
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public Post get(long id){
        return em.find(Post.class, id);
    }

    public void update(Post post){
        em.getTransaction().begin();
        em.merge(post);
        em.getTransaction().commit();
    }


    public List<Post> getAll(){
        TypedQuery<Post> namedQuery = em.createNamedQuery("Post.getAll", Post.class);
        return namedQuery.getResultList();
    }
}
