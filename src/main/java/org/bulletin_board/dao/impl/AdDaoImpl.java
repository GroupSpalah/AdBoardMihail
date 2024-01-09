
package org.bulletin_board.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lombok.Cleanup;
import org.bulletin_board.dao.CrudDAO;
import org.bulletin_board.domain.Ad;

import java.sql.SQLException;

import static org.bulletin_board.util.Constans.FACTORY;

public class AdDaoImpl implements CrudDAO<Ad> {

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

    }

    @Override
    public void delete(Ad ad) throws SQLException {

    }

    @Override
    public void deleteAll(Ad ad) throws SQLException {

    }

    @Override
    public void show(Ad ad) throws SQLException {

    }

    @Override
    public void filtration(Ad ad) throws SQLException {

    }

 }

