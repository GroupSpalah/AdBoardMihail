package org.bulletin_board.service;
import org.bulletin_board.domain.Ad;
import org.bulletin_board.domain.Category;
import org.bulletin_board.service.CrudService;

import java.sql.SQLException;

public interface CategoryService extends CrudService<Category> {
    public void show(Category category) throws SQLException;
    public void filtration(Category category) throws SQLException;
    public void delete(int id) throws SQLException;

}
