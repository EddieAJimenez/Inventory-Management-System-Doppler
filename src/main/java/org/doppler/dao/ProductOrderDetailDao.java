package org.doppler.dao;

import org.doppler.db.HibernateUtil;
import org.doppler.models.ProductOrderDetail;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ProductOrderDetailDao {
    public void save(ProductOrderDetail productOrderDetail) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(productOrderDetail);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw e;
        }
    }

    public void update(ProductOrderDetail productOrderDetail) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(productOrderDetail);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw e;
        }
    }

    public void delete(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            ProductOrderDetail productOrderDetail = session.get(ProductOrderDetail.class, id);

            if (productOrderDetail != null) {
                session.remove(productOrderDetail);
                System.out.println("ProductOrderDetail " + id + " was deleted");
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public ProductOrderDetail getById(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            ProductOrderDetail productOrderDetail = session.byId(ProductOrderDetail.class).getReference(id);
            transaction.commit();
            return productOrderDetail;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw e;
        }
    }

    public List<ProductOrderDetail> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from ProductOrderDetail", ProductOrderDetail.class).list();
        }
    }
}
