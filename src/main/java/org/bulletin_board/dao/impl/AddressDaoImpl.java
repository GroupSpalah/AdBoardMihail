
package org.bulletin_board.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lombok.Cleanup;
import org.bulletin_board.dao.CrudDAO;
import org.bulletin_board.domain.Address;
import org.bulletin_board.domain.Email;

import java.sql.SQLException;

import static org.bulletin_board.util.Constans.*;

public class AddressDaoImpl implements CrudDAO<Address> {

    @Override
    public void add(Address address) throws SQLException {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(address);

        transaction.commit();
    }

    @Override
    public Address findById(int id) throws SQLException {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Address address = em.find(Address.class, id);

        transaction.commit();
        return address;
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


}

