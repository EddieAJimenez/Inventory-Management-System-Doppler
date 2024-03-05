package org.doppler.dao;

import org.doppler.db.HibernateUtil;
import org.doppler.models.ServiceStatus;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ServiceStatusDao {
    public void save(ServiceStatus serviceStatus) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(serviceStatus);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw e;
        }
    }

    public void update(ServiceStatus serviceStatus) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(serviceStatus);
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
            ServiceStatus serviceStatus = session.get(ServiceStatus.class, id);

            if (serviceStatus != null) {
                session.remove(serviceStatus);
                System.out.println("ServiceStatus " + id + " was deleted");
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public ServiceStatus getById(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            ServiceStatus serviceStatus = session.byId(ServiceStatus.class).getReference(id);
            transaction.commit();
            return serviceStatus;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw e;
        }
    }

    public List<ServiceStatus> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from ServiceStatus", ServiceStatus.class).list();
        }
    }
}
