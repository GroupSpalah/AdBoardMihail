
package org.bulletin_board.service.imp;
import org.bulletin_board.dao.CrudDAO;
import org.bulletin_board.dao.impl.AddressDaoImpl;
import org.bulletin_board.domain.Address;
import org.bulletin_board.domain.Email;
import org.bulletin_board.service.CrudService;

import java.sql.SQLException;

public class AddressServiceImpl implements CrudService<Address> {

    private CrudDAO<Address> dao;

    public AddressServiceImpl() {
        dao = new AddressDaoImpl();
    }

    @Override
    public void add(Address address) throws SQLException {
        dao.add(address);

    }

    @Override
    public void update(Address address) throws SQLException {

    }

    @Override
    public void delete(Address address) throws SQLException {

    }

    @Override
    public void deleteAll(Address address) throws SQLException {

    }

    @Override
    public void show(Address address) throws SQLException {

    }

    @Override
    public void filtration(Address address) throws SQLException {

    }

    @Override
    public Address findById(int id) throws SQLException {
        return dao.findById(id);
    }
}


