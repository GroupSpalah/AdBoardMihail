
package org.bulletin_board.service.imp;
import org.bulletin_board.dao.CrudDAO;
import org.bulletin_board.dao.impl.CategoryDaoImpl;
import org.bulletin_board.domain.Category;
import org.bulletin_board.service.CrudService;

import java.sql.SQLException;

public class CategoryServiceImpl implements CrudService<Category> {

    private CrudDAO<Category> dao;

    public CategoryServiceImpl() {
        dao = new CategoryDaoImpl();
    }


    @Override
    public void add(Category category) throws SQLException {
        dao.add(category);

    }

    @Override
    public void update(Category category) throws SQLException {
        dao.update(category);

    }

    @Override
    public void delete(Category category) throws SQLException {
        dao.delete(category);

    }

    @Override
    public void deleteAll(Category category) throws SQLException {
        dao.deleteAll(category);

    }

    @Override
    public void show(Category category) throws SQLException {

    }

    @Override
    public void filtration(Category category) throws SQLException {

    }

    @Override
    public Category findById(int id) throws SQLException {
        return dao.findById(id);
    }
}


