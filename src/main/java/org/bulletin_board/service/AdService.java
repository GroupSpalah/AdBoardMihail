package org.bulletin_board.service;
import org.bulletin_board.domain.Ad;
import java.sql.SQLException;

public interface AdService extends CrudService<Ad>{
    public void show(Ad ad) throws SQLException;
    public void filtration(Ad ad) throws SQLException;
    public void delete(int id) throws SQLException;

}
