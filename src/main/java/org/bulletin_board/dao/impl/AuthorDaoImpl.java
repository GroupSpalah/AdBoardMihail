
package org.bulletin_board.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import lombok.Cleanup;
import org.bulletin_board.dao.CrudDAO;
import org.bulletin_board.domain.Address;
import org.bulletin_board.domain.Author;
import org.bulletin_board.service.AdService;
import org.bulletin_board.service.imp.AdServiceImpl;

import java.sql.SQLException;

import static org.bulletin_board.util.Constans.*;

public class AuthorDaoImpl implements CrudDAO<Author> {

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


}

