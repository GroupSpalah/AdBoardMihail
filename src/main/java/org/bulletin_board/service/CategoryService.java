package org.bulletin_board.service;

import org.bulletin_board.domain.Category;

import java.sql.SQLException;

public interface CategoryService extends CrudService<Category> {
    public void delete(int id) throws SQLException;

}
