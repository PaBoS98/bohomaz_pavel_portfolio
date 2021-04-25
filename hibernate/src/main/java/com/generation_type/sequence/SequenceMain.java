package com.generation_type.sequence;


import com.generation_type.sequence.config.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;

public class SequenceMain {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Sequence sequence;
        for (int i = 0; i < 5; i++) {
            sequence = new Sequence();
            sequence.setName("sequence generation " + i);
            session.save(sequence);
        }
        session.getTransaction().commit();

        session.beginTransaction();
        Query query = session.createQuery("DELETE FROM Sequence WHERE id = 5");
        query.executeUpdate();
        session.getTransaction().commit();

        session.beginTransaction();
        for (int i = 0; i < 5; i++) {
            sequence = new Sequence();
            sequence.setName("sequence generation " + i);
            session.save(sequence);
        }
        session.getTransaction().commit();

        HibernateUtil.shutdown();
    }
}
