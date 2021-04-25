package com.generation_type.auto;

import com.generation_type.auto.config.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;

public class AutoMain {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Auto auto;
        for (int i = 0; i < 5; i++) {
            auto = new Auto();
            auto.setName("auto generation " + i);
            session.save(auto);
        }
        session.getTransaction().commit();

        session.beginTransaction();
        Query query = session.createQuery("DELETE FROM Auto WHERE id = 5");
        query.executeUpdate();
        session.getTransaction().commit();

        session.beginTransaction();
        for (int i = 0; i < 5; i++) {
            auto = new Auto();
            auto.setName("auto generation " + i);
            session.save(auto);
        }
        session.getTransaction().commit();

        HibernateUtil.shutdown();
    }
}
