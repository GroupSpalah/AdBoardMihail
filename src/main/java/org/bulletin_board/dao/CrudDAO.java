package org.bulletin_board.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.sql.SQLException;


public interface CrudDAO<T> {


    public void add(T t) throws SQLException;


    public void update(T t) throws SQLException;


    public void delete(int id) throws SQLException;

    public T findById(int id) throws SQLException;


}
