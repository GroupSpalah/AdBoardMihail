package org.bulletin_board.service;

import java.sql.SQLException;

public interface CrudService<T> {
    public void add(T t) throws SQLException;

    public void update(T t) throws SQLException;

    public T findById(int id) throws SQLException;

}
