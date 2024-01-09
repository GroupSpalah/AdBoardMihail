
package org.bulletin_board.service.imp;

import org.bulletin_board.dao.CrudDAO;
import org.bulletin_board.dao.impl.AuthorDaoImpl;
import org.bulletin_board.domain.Author;
import org.bulletin_board.service.CrudService;

import java.sql.SQLException;

public class AuthorServiceImpl implements CrudService<Author> {

    private CrudDAO<Author> dao;

    public AuthorServiceImpl() {
        dao = new AuthorDaoImpl();
    }


    @Override
    public void add(Author author) throws SQLException {
        dao.add(author);

    }

    @Override
    public void update(Author author) throws SQLException {
        dao.update(author);

    }

    @Override
    public void delete(Author author) throws SQLException {

    }

    @Override
    public void deleteAll(Author author) throws SQLException {

    }

    @Override
    public void show(Author author) throws SQLException {

    }

    @Override
    public void filtration(Author author) throws SQLException {

    }

    @Override
    public Author findById(int id) throws SQLException {
        return dao.findById(id);
    }
}

