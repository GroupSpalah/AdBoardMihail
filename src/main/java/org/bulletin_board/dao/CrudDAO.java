package org.bulletin_board.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import lombok.Cleanup;
import org.bulletin_board.domain.Ad;

import java.sql.SQLException;

import static org.bulletin_board.util.Constans.FACTORY;

public interface CrudDAO<T> {

    public default void add(T t) throws SQLException {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(t);
        transaction.commit();
    }


    public void update(T t) throws SQLException;


    public default void delete(Class<T> aClass,int id) throws SQLException {
        String name = aClass.getSimpleName();
        @Cleanup

        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Query query = em.createQuery("DELETE FROM"+ name +"c WHERE c.id =: c_id");
        query.setParameter("c_id", id);
        query.executeUpdate();

        transaction.commit();

    }

    public default T findById(Class<T> aClass, int id) throws SQLException {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        T entity = em.find(aClass, id);
        transaction.commit();
        return entity;
    }


}
