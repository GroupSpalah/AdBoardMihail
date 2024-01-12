
package org.bulletin_board.service.imp;
import org.bulletin_board.dao.CategoryDAO;
import org.bulletin_board.dao.CrudDAO;
import org.bulletin_board.dao.impl.CategoryDaoImpl;
import org.bulletin_board.domain.Ad;
import org.bulletin_board.domain.Category;
import org.bulletin_board.service.CategoryService;
import org.bulletin_board.service.CrudService;

import java.sql.SQLException;

public class CategoryServiceImpl implements CategoryService {

    private CategoryDAO dao;

    public CategoryServiceImpl() {
        dao = new CategoryDaoImpl();
    }


    @Override
    public void add(Category category) throws SQLException {
        dao.add(category);

    }

    @Override
    public void update(int id) throws SQLException {
        dao.update(id);

    }


    @Override
    public Category findById(int id) throws SQLException {
        return dao.findById(id);
    }


    @Override
    public void show(Category category) throws SQLException {
        dao.show(category);
    }

    @Override
    public void filtration(Category category) throws SQLException {
        dao.filtration(category);

    }

    @Override
    public void delete(int id) throws SQLException {
        dao.delete(id);

    }
}


