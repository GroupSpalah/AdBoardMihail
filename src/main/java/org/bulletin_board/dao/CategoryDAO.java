package org.bulletin_board.dao;

import org.bulletin_board.domain.Ad;
import org.bulletin_board.domain.Category;

import java.sql.SQLException;

public interface CategoryDAO extends CrudDAO<Category> {
    public void show(Category category) throws SQLException;
    public void filtration(Category category) throws SQLException;
    public void delete(int id) throws SQLException;



}
