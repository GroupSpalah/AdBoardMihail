
package org.bulletin_board.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import lombok.Cleanup;
import org.bulletin_board.dao.CategoryDAO;
import org.bulletin_board.domain.Category;
import org.bulletin_board.service.AdService;
import org.bulletin_board.service.imp.AdServiceImpl;

import java.sql.SQLException;

import static org.bulletin_board.util.Constans.*;


public class CategoryDaoImpl implements CategoryDAO {
    @Override
    public void add(Category category) throws SQLException {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(category);

        transaction.commit();

    }

    @Override
    public void update(Category category) throws SQLException {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Category category1 = em.merge(category);

        em.persist(category1);

        transaction.commit();

    }

    @Override
    public Category findById(int id) throws SQLException {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Category category = em.find(Category.class, id);

        transaction.commit();
        return category;
    }

    @Override
    public void delete(int id) throws SQLException {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        AdService ad = new AdServiceImpl();
        ad.deleteAll();

        Query query = em.createQuery("DELETE FROM Category c WHERE c.id =: c_id");

        query.setParameter("c_id", id);

        query.executeUpdate();

        transaction.commit();

    }

}




