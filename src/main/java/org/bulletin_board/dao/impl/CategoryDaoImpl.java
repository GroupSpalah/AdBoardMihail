
package org.bulletin_board.dao.impl;
import lombok.Cleanup;
import org.bulletin_board.dao.CrudDAO;
import org.bulletin_board.domain.Category;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.sql.SQLException;

import static org.bulletin_board.util.Constans.*;

@Repository
@Transactional
public class CategoryDaoImpl implements CrudDAO<Category> {
    @PersistenceContext
    EntityManager em;

    @Override
    public void add(Category category) throws SQLException {

        em.persist(category);

    }

    @Override
    public void update(Category category) throws SQLException {

        Category category1 = em.merge(category);

        em.persist(category1);

    }

    @Override
    public void delete(int id) throws SQLException {
        Query query = em.createQuery("DELETE FROM Category c WHERE c.id =: c_id");
        query.setParameter("c_id", id);
        query.executeUpdate();
    }

    @Override
    public Category findById(int id) throws SQLException {
        return em.find(Category.class, id);
    }
}




