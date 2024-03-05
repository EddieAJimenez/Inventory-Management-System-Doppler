package org.doppler.dao;

import org.doppler.db.HibernateUtil;
import org.doppler.models.OrderStatus;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class OrderStatusDao {
    public void save(OrderStatus orderStatus) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(orderStatus);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw e;
        }
    }

    public void update(OrderStatus orderStatus) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(orderStatus);
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
            OrderStatus orderStatus = session.get(OrderStatus.class, id);

            if (orderStatus != null) {
                session.remove(orderStatus);
                System.out.println("OrderStatus " + id + " was deleted");
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public OrderStatus getById(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            OrderStatus orderStatus = session.byId(OrderStatus.class).getReference(id);
            transaction.commit();
            return orderStatus;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw e;
        }
    }

    public List<OrderStatus> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from OrderStatus", OrderStatus.class).list();
        }
    }
}
