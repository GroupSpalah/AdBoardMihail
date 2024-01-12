
package org.bulletin_board.service.imp;
import org.bulletin_board.dao.AdDAO;
import org.bulletin_board.dao.impl.AdDaoImpl;
import org.bulletin_board.domain.Ad;
import org.bulletin_board.service.AdService;

import java.sql.SQLException;

public class AdServiceImpl implements AdService {

    private AdDAO dao;

    public AdServiceImpl() {
        dao = new AdDaoImpl();
    }

    @Override
    public void add(Ad ad) throws SQLException {
        dao.add(ad);
    }

    @Override
    public void update(int id) throws SQLException {
        dao.update(id);

    }


    @Override
    public void show(Ad ad) throws SQLException {
        dao.show(ad);

    }

    @Override
    public void filtration(Ad ad) throws SQLException {
        dao.filtration(ad);

    }

    @Override
    public void delete(int id) throws SQLException {
        dao.delete(id);
    }

    @Override
    public Ad findById(int id) throws SQLException {
        return dao.findById(id);
    }
}

