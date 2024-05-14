
package org.bulletin_board.dao.impl;

import org.bulletin_board.dao.AdDAO;
import org.bulletin_board.domain.Ad;
import org.bulletin_board.domain.Category;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public class AdDaoImpl implements AdDAO {

    @PersistenceContext
    EntityManager em;

    @Override
    public void deleteAll() throws SQLException {
        Query query = em.createQuery("DELETE FROM Ad");
        query.executeUpdate();


    }

    @Override
    public void add(Ad ad) throws SQLException {
        em.persist(ad);
    }

    @Override
    public void update(Ad ad) throws SQLException {
        Ad ad1 = em.merge(ad);
        em.persist(ad1);

    }

    @Override
    public void delete(int id) throws SQLException {

        Query query = em.createQuery("DELETE FROM AD a WHERE a.id =: a_id");
        query.setParameter("a_id", id);
        query.executeUpdate();

    }

    @Override
    public Ad findById(int id) throws SQLException {

        return em.find(Ad.class, id);
    }

    @Override
    public List<Ad> showAd(Category category) throws SQLException {
        TypedQuery<Ad> query =
                em.createQuery("SELECT a FROM Ad a WHERE a.category.name =: a_category_name", Ad.class);
        query.setParameter("a_category_name", category.getName());
        System.out.println(query.getResultList());
        return query.getResultList();
    }

    @Override
    public List<Ad> showByAuthor(String name) throws SQLException {
        TypedQuery<Ad> query =
                em.createQuery("SELECT a FROM Ad a WHERE a.author.name =: a_author_name", Ad.class);
        query.setParameter("a_author_name", name);
        System.out.println(query.getResultList());

        return query.getResultList();
    }

    @Override
    public List<Ad> showByKeyWord(String word) throws SQLException {
        TypedQuery<Ad> query =
                em.createQuery("SELECT a FROM Ad a WHERE a.text LIKE CONCAT('%', :word, '%')", Ad.class);
        query.setParameter("word", word);
        System.out.println(query.getResultList());

        return query.getResultList();
    }

    @Override
    public List<Ad> showDate(LocalDate date) throws SQLException {
        TypedQuery<Ad> query =
                em.createQuery("SELECT a FROM Ad a WHERE a.date = :a_date", Ad.class);
        query.setParameter("a_date", date);
        System.out.println(query.getResultList());

        return query.getResultList();
    }

}

