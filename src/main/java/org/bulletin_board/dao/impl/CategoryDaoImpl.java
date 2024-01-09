
package org.bulletin_board.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lombok.Cleanup;
import org.bulletin_board.dao.CrudDAO;
import org.bulletin_board.domain.Category;
import java.sql.SQLException;
import static org.bulletin_board.util.Constans.*;


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
    public void update(Category category) throws SQLException {

    }

    @Override
    public void delete(Category category) throws SQLException {

    }

    @Override
    public void deleteAll(Category category) throws SQLException {

    }

    @Override
    public void show(Category category) throws SQLException {

    }

    @Override
    public void filtration(Category category) throws SQLException {

    }

}




