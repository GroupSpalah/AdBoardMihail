
package org.bulletin_board.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import lombok.Cleanup;
import org.bulletin_board.dao.CrudDAO;
import org.bulletin_board.domain.Category;
import org.bulletin_board.service.AdService;
import org.bulletin_board.service.imp.AdServiceImpl;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

import static org.bulletin_board.util.Constans.*;

@Repository
public class CategoryDaoImpl implements CrudDAO<Category> {

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
}




