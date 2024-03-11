package org.doppler.dao;

import org.doppler.db.HibernateUtil;
import org.doppler.models.ServiceOrderDetail;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ServiceOrderDetailDao {
    public void save(ServiceOrderDetail serviceOrderDetail) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(serviceOrderDetail);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw e;
        }
    }

    public void update(ServiceOrderDetail serviceOrderDetail) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(serviceOrderDetail);
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
            ServiceOrderDetail serviceOrderDetail = session.get(ServiceOrderDetail.class, id);

            if (serviceOrderDetail != null) {
                session.remove(serviceOrderDetail);
                System.out.println("Services " + id + " was deleted");
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public ServiceOrderDetail getById(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            ServiceOrderDetail serviceOrderDetail = session.byId(ServiceOrderDetail.class).getReference(id);
            transaction.commit();
            return serviceOrderDetail;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw e;
        }
    }

    public List<ServiceOrderDetail> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Services", ServiceOrderDetail.class).list();
        }
    }
}
