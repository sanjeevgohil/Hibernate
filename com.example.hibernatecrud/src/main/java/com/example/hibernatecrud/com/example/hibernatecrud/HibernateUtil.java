package com.example.hibernatecrud.com.example.hibernatecrud;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernatecrud.com.example.hibernatecrud.Student;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
