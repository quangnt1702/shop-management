package com.quangnt.dao;

import com.quangnt.entities.Category;
import com.quangnt.entities.Product;
import com.quangnt.helpers.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ACER
 */
public class ProductDAO {

    public Product insertProduct(Product product) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(product);
            transaction.commit();
            return product;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    public Product updateProduct(Product product) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(product);
            transaction.commit();
            return product;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    public void deleteProduct(int productID) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Product product = (Product) session.get(Product.class, productID);
            session.delete(product);
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

    public Product getProductByID(int productID) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Product product = (Product) session.get(Product.class, productID);
            if (product.getCategories() != null) {
                Category category = new Category();
                category.setCategoryId(product.getCategories().getCategoryId());
                category.setCategoryName(product.getCategories().getCategoryName());
                product.setCategories(category);
            }
            return product;
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }

    public List<Product> getAllProduct() throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "FROM Product";
            Query query = session.createQuery(hql);
            List<Product> list = new ArrayList<>();
            list = query.list();
            for (Product product : list) {
                if (product.getCategories() != null) {
                    Category category = new Category();
                    category.setCategoryId(product.getCategories().getCategoryId());
                    category.setCategoryName(product.getCategories().getCategoryName());
                    product.setCategories(category);
                }
            }
            return list;
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }

    public List<Product> getProductByName(String name) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "FROM Product WHERE productName like :name";
            Query query = session.createQuery(hql);
            query.setParameter("name", "%" + name + "%");
            List<Product> list = new ArrayList<>();
            list = query.list();
            for (Product product : list) {
                if (product.getCategories() != null) {
                    Category category = new Category();
                    category.setCategoryId(product.getCategories().getCategoryId());
                    category.setCategoryName(product.getCategories().getCategoryName());
                    product.setCategories(category);
                }
            }
            return list;
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }
}
