
package org.bulletin_board.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import lombok.Cleanup;
import org.bulletin_board.dao.AdDAO;
import org.bulletin_board.domain.Ad;
import org.bulletin_board.domain.Author;

import java.sql.SQLException;

import static org.bulletin_board.util.Constans.FACTORY;

public class AdDaoImpl implements AdDAO {

    @Override
    public void add(Ad ad) throws SQLException {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(ad);

        transaction.commit();

    }

    @Override
    public Ad findById(int id) throws SQLException {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Ad ad = em.find(Ad.class, id);

        transaction.commit();
        return ad;
    }

    @Override
    public void update(Ad ad) throws SQLException {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();


        transaction.commit();
    }

    @Override
    public void delete(int id) throws SQLException {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Query query = em.createQuery("DELETE FROM Ad c WHERE c.id =: c_id");
        query.setParameter("c_id", id);

        query.executeUpdate();

        transaction.commit();

    }

    @Override
    public void show(Ad ad) throws SQLException {

    }

    @Override
    public void filtration(Ad ad) throws SQLException {

    }
}

