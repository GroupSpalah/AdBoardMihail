package org.bulletin_board.dao.impl;

import org.bulletin_board.dao.CrudDAO;
import org.bulletin_board.domain.MatchingAd;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.sql.SQLException;

@Repository
@Transactional
public class MatchingAdDaoImpl implements CrudDAO<MatchingAd> {
    @PersistenceContext
    EntityManager em;

    @Override
    public void add(MatchingAd matchingAd) throws SQLException {
        em.persist(matchingAd);
    }

    @Override
    public void update(MatchingAd matchingAd) throws SQLException {

        MatchingAd matchingAd1 = em.merge(matchingAd);

        em.persist(matchingAd1);

    }

    @Override
    public void delete(int id) throws SQLException {
        Query query = em.createQuery("DELETE FROM MatchingAd m WHERE m.id =: m_id");
        query.setParameter("m_id", id);
        query.executeUpdate();

    }

    @Override
    public MatchingAd findById(int id) throws SQLException {
        return em.find(MatchingAd.class, id);
    }

}
