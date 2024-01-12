package org.bulletin_board.dao;
import org.bulletin_board.domain.Ad;
import java.sql.SQLException;

public interface AdDAO extends CrudDAO<Ad> {

    public void show(Ad ad) throws SQLException;
    public void filtration(Ad ad) throws SQLException;
    public void delete(int id) throws SQLException;

}
