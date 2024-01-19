
package org.bulletin_board.service.imp;

import org.bulletin_board.dao.AdDAO;
import org.bulletin_board.dao.impl.AdDaoImpl;
import org.bulletin_board.domain.Ad;
import org.bulletin_board.domain.Category;
import org.bulletin_board.service.AdService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

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
    public void update(Ad ad) throws SQLException {
        dao.update(ad);

    }

    @Override
    public List<Ad> showAd(Category category) throws SQLException {
        return dao.showAd(category);
    }

    @Override
    public List<Ad> showByAuthor(String name) throws SQLException {
        return dao.showByAuthor(name);
    }

    @Override
    public List<Ad> showByKeyWord(String word) throws SQLException {
        return dao.showByKeyWord(word);
    }

    @Override
    public List<Ad> showDate(LocalDate date) throws SQLException {
        return dao.showDate(date);
    }

    @Override
    public void delete(int id) throws SQLException {
        dao.delete(id);
    }

    @Override
    public Ad findById(int id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void deleteAll() throws SQLException {
        dao.deleteAll();
    }
}

