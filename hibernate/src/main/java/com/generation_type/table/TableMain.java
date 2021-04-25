package com.generation_type.table;

import com.generation_type.table.config.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;

public class TableMain {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Table1 table1;
        for (int i = 0; i < 5; i++) {
            table1 = new Table1();
            table1.setName("table1 generation " + i);
            session.save(table1);
        }
        session.getTransaction().commit();

        session.beginTransaction();
        Query query = session.createQuery("DELETE FROM Table1 WHERE id = 5");
        query.executeUpdate();
        session.getTransaction().commit();

        session.beginTransaction();
        for (int i = 0; i < 5; i++) {
            table1 = new Table1();
            table1.setName("table1 generation " + i);
            session.save(table1);
        }
        session.getTransaction().commit();

        HibernateUtil.shutdown();
    }
}
