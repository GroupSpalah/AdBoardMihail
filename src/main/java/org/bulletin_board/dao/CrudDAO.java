package org.bulletin_board.dao;

import java.sql.SQLException;

public interface CrudDAO<T> {
    public void add(T t) throws SQLException;
    public void update(T t) throws SQLException;
    public void delete(T t) throws SQLException;
    public void deleteAll(T t) throws SQLException;
    public void show(T t) throws SQLException;
    public void filtration(T t) throws SQLException;
    public T findById(int id) throws SQLException;


}
