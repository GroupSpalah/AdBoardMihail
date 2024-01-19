
package org.bulletin_board.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lombok.Cleanup;
import org.bulletin_board.dao.CrudDAO;
import org.bulletin_board.domain.Author;

import java.sql.SQLException;

import static org.bulletin_board.util.Constans.*;

public class AuthorDaoImpl implements CrudDAO<Author> {


    @Override
    public void add(Author author) throws SQLException {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(author);

        transaction.commit();

    }

    @Override
    public void update(Author author) throws SQLException {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Author author1 = em.merge(author);

        em.persist(author1);

        transaction.commit();
    }

    @Override
    public Author findById(int id) throws SQLException {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Author author = em.find(Author.class, id);

        transaction.commit();
        return author;
    }

}

