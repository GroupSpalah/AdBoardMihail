
package org.bulletin_board.dao.impl;

import org.bulletin_board.dao.CrudDAO;
import org.bulletin_board.domain.Author;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.sql.SQLException;

@Repository
@Transactional
public class AuthorDaoImpl implements CrudDAO<Author> {

    @PersistenceContext
    EntityManager em;

    @Override
    public void add(Author author) throws SQLException {
        em.persist(author);
    }

    @Override
    public void update(Author author) throws SQLException {

        Author author1 = em.merge(author);

        em.persist(author1);

    }

    @Override
    public void delete(int id) throws SQLException {
        Query query = em.createQuery("DELETE FROM Author a WHERE a.id =: a_id");
        query.setParameter("a_id", id);
        query.executeUpdate();

    }

    @Override
    public Author findById(int id) throws SQLException {
        return em.find(Author.class, id);
    }


}

