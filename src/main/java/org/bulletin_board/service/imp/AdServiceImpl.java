
package org.bulletin_board.service.imp;

import org.bulletin_board.dao.CrudDAO;
import org.bulletin_board.dao.impl.AdDaoImpl;
import org.bulletin_board.dao.impl.AuthorDaoImpl;
import org.bulletin_board.domain.Ad;
import org.bulletin_board.domain.Author;
import org.bulletin_board.service.CrudService;

import java.sql.SQLException;

public class AdServiceImpl implements CrudService<Ad> {

    private CrudDAO<Ad> dao;

    public AdServiceImpl() {
        dao = new AdDaoImpl();
    }

    @Override
    public void add(Ad ad) throws SQLException {
        dao.add(ad);
    }

    @Override
    public void update(Ad ad) throws SQLException {
        dao.update(ad);

    }

    @Override
    public void delete(Ad ad) throws SQLException {

    }

    @Override
    public void deleteAll(Ad ad) throws SQLException {

    }

    @Override
    public void show(Ad ad) throws SQLException {

    }

    @Override
    public void filtration(Ad ad) throws SQLException {

    }

    @Override
    public Ad findById(int id) throws SQLException {
        return dao.findById(id);
    }
}

