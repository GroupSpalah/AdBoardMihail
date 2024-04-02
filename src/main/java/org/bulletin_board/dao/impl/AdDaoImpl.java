
package org.bulletin_board.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import lombok.Cleanup;
import org.bulletin_board.dao.AdDAO;
import org.bulletin_board.domain.Ad;
import org.bulletin_board.domain.Category;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static org.bulletin_board.util.Constans.FACTORY;

public class AdDaoImpl implements AdDAO {

    @Override
    public void deleteAll() throws SQLException {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Query query = em.createQuery("DELETE FROM Ad");

        query.executeUpdate();

        transaction.commit();

    }

    @Override
    public void update(Ad ad) throws SQLException {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Ad ad1 = em.merge(ad);

        em.persist(ad1);

        transaction.commit();
    }

    @Override
    public List<Ad> showAd(Category category) throws SQLException {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<Ad> query =
                em.createQuery("SELECT a FROM Ad a WHERE a.category.name =: a_category_name", Ad.class);
        query.setParameter("a_category_name", category.getName());
        List<Ad> ads = query.getResultList();
        System.out.println(ads);

        transaction.commit();
        return ads;
    }

    @Override
    public List<Ad> showByAuthor(String name) throws SQLException {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<Ad> query =
                em.createQuery("SELECT a FROM Ad a WHERE a.author.name =: a_author_name", Ad.class);
        query.setParameter("a_author_name", name);
        List<Ad> ads = query.getResultList();
        System.out.println(ads);

        transaction.commit();
        return ads;
    }

    @Override
    public List<Ad> showByKeyWord(String word) throws SQLException {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<Ad> query =
                em.createQuery("SELECT a FROM Ad a WHERE a.text LIKE CONCAT('%', :word, '%')", Ad.class);
        query.setParameter("word", word);
        List<Ad> ads = query.getResultList();
        System.out.println(ads);

        transaction.commit();
        return ads;
    }

    @Override
    public List<Ad> showDate(LocalDate date) throws SQLException {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<Ad> query =
                em.createQuery("SELECT a FROM Ad a WHERE a.date = :a_date", Ad.class);
        query.setParameter("a_date", date);
        List<Ad> ads = query.getResultList();
        System.out.println(ads);

        transaction.commit();
        return ads;
    }

}

