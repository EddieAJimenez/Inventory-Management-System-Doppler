package org.doppler.db;

import org.doppler.models.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/dopplerdb?useSSL=false");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "rootroot");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.ENABLE_LAZY_LOAD_NO_TRANS, "true");
                settings.put(Environment.HBM2DDL_AUTO, "validate");

                configuration.setProperties(settings);
                configuration.addAnnotatedClass(Customer.class);
                configuration.addAnnotatedClass(Order.class);
                configuration.addAnnotatedClass(OrderStatus.class);
                configuration.addAnnotatedClass(Product.class);
                configuration.addAnnotatedClass(ProductOrderDetail.class);
                configuration.addAnnotatedClass(ProductType.class);
                configuration.addAnnotatedClass(Service.class);
                configuration.addAnnotatedClass(ServiceOrderDetail.class);
                configuration.addAnnotatedClass(ServiceStatus.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}