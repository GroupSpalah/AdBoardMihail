package org.bulletin_board.service;

import org.bulletin_board.domain.Ad;
import org.bulletin_board.domain.Category;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface AdService extends CrudService<Ad> {
    public List<Ad> showAd(Category category) throws SQLException;

    public List<Ad> showByAuthor(String name) throws SQLException;

    public List<Ad> showByKeyWord(String word) throws SQLException;

    public List<Ad> showDate(LocalDate date) throws SQLException;

    public void deleteAll() throws SQLException;

}
