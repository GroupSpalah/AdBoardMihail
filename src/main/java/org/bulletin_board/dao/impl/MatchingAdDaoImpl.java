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
    public void update(MatchingAd matchingAd) throws SQLException {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        MatchingAd matchingAd1 = em.merge(matchingAd);

        em.persist(matchingAd);

        transaction.commit();

    }

}
