package com.generation_type.identity;

import com.generation_type.identity.config.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;

public class IdentityMain {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Identity identity;
        for (int i = 0; i < 5; i++) {
            identity = new Identity();
            identity.setName("identity generation " + i);
            session.save(identity);
        }
        session.getTransaction().commit();

        session.beginTransaction();
        Query query = session.createQuery("DELETE FROM Identity WHERE id = 5");
        query.executeUpdate();
        session.getTransaction().commit();

        session.beginTransaction();
        for (int i = 0; i < 5; i++) {
            identity = new Identity();
            identity.setName("identity generation " + i);
            session.save(identity);
        }
        session.getTransaction().commit();

        HibernateUtil.shutdown();
    }
}
