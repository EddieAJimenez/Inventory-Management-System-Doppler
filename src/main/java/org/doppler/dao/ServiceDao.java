package org.doppler.dao;

import org.doppler.db.HibernateUtil;
import org.doppler.models.Service;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ServiceDao {
    public boolean save(Service service) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(service);
            transaction.commit();
            return true; // return true if save is successful
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false; // return false if any exception occurs
        }
    }


    public void update(Service service) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(service);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw e;
        }
    }

    public boolean delete(int id) {
    Transaction transaction = null;
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        transaction = session.beginTransaction();
        Service service = session.get(Service.class, id);

        if (service != null) {
            session.remove(service);
            System.out.println("Services " + id + " was deleted");
            transaction.commit();
            return true; // return true if service is successfully deleted
        } else {
            return false; // return false if service is not found
        }
    } catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
        return false; // return false if any exception occurs
    }
}

    public Service getById(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Service service = session.byId(Service.class).getReference(id);
            transaction.commit();
            return service;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw e;
        }
    }

    public List<Service> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Service", Service.class).list();
        }
    }
}
