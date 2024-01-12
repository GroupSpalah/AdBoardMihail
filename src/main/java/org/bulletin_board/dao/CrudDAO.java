package org.bulletin_board.dao;

import java.sql.SQLException;

public interface CrudDAO<T> {
    public void add(T t) throws SQLException;
    public void update(int id) throws SQLException;
    public T findById(int id) throws SQLException;


}
