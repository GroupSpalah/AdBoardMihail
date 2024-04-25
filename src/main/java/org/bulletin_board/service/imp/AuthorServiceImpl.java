
package org.bulletin_board.service.imp;

import lombok.AllArgsConstructor;
import org.bulletin_board.dao.CrudDAO;
import org.bulletin_board.dao.impl.AuthorDaoImpl;
import org.bulletin_board.domain.Author;
import org.bulletin_board.service.CrudService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
@Service
@AllArgsConstructor
public class AuthorServiceImpl implements CrudService<Author> {

    private CrudDAO<Author> dao;

    @Override
    public void add(Author author) throws SQLException {
        dao.add(author);

    }

    @Override
    public void update(Author author) throws SQLException {
        dao.update(author);

    }

    @Override
    public void delete(int id) throws SQLException {
        dao.delete(Author.class, id);
    }

    @Override
    public Author findById(int id) throws SQLException {
        return dao.findById(Author.class, id);
    }

}

