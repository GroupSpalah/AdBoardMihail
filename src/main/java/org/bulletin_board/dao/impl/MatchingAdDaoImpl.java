package org.bulletin_board.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import lombok.Cleanup;
import org.bulletin_board.dao.CrudDAO;
import org.bulletin_board.domain.MatchingAd;
import java.sql.SQLException;

import static org.bulletin_board.util.Constans.FACTORY;

public class MatchingAdDaoImpl implements CrudDAO<MatchingAd> {
    @Override
    public void add(MatchingAd matchingAd) throws SQLException {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(matchingAd);

        transaction.commit();

    }

    @Override
    public void update(MatchingAd matchingAd) throws SQLException {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        MatchingAd matchingAd1 = em.merge(matchingAd);

        em.persist(matchingAd);

        transaction.commit();

    }

    @Override
    public void delete(int id) throws SQLException {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();


        Query query = em.createQuery("DELETE FROM MatchingAd c WHERE c.id =: c_id");

        query.setParameter("c_id", id);

        query.executeUpdate();

        transaction.commit();

    }

    @Override
    public MatchingAd findById(int id) throws SQLException {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        MatchingAd matchingAd = em.find(MatchingAd.class, id);

        transaction.commit();
        return matchingAd;
    }
}
