package com.quangnt.dao;

import com.quangnt.entities.Category;
import com.quangnt.helpers.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ACER
 */
public class CategoryDAO {

    public Category insertCategory(Category category) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(category);
            transaction.commit();
            return category;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    public Category updateCategory(Category category) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(category);
            transaction.commit();
            return category;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    public void deleteCategory(int categoryID) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Category category = (Category) session.get(Category.class, categoryID);
            session.delete(category);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    public Category getCategoryByID(int categoryID) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Category category = (Category) session.get(Category.class, categoryID);
            return category;
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }

    public List<Category> getAllCategories() throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "FROM Category";
            Query query = session.createQuery(hql);
            return query.list();
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }

    public List<Category> getCategoryByName(String name) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "FROM Category WHERE categoryName like :name";
            Query query = session.createQuery(hql);
            query.setParameter("name", "%" + name + "%");
            return query.list();
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }
}
