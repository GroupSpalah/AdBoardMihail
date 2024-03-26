package org.bulletin_board.service.imp;

import org.bulletin_board.dao.CrudDAO;
import org.bulletin_board.dao.impl.MatchingAdDaoImpl;
import org.bulletin_board.domain.MatchingAd;
import org.bulletin_board.service.CrudService;

import java.sql.SQLException;

public class MatchingAdServiceImpl implements CrudService<MatchingAd> {

    private CrudDAO<MatchingAd> dao;

    public MatchingAdServiceImpl() {
        dao = new MatchingAdDaoImpl();
    }

    @Override
    public void add(MatchingAd matchingAd) throws SQLException {
        dao.add(matchingAd);

    }

    @Override
    public void update(MatchingAd matchingAd) throws SQLException {
        dao.update(matchingAd);

    }

    @Override
    public void delete(int id) throws SQLException {
        dao.delete(id);

    }

    @Override
    public MatchingAd findById(int id) throws SQLException {
        return dao.findById(id);
    }
}
