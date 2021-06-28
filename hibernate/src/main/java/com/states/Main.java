package com.states;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.OptimisticLocking;
import org.hibernate.cfg.Configuration;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
import java.io.File;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        //Transient
        SomeEntity newObject = new SomeEntity();
        newObject.setName("object#1");

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.lock(newObject, LockMode.READ);

        //Persistent
        session.save(newObject);

        //Detached
        transaction.commit();
        session.close();

        transaction = session.beginTransaction();
        SomeEntity oldObject = session.load(SomeEntity.class, 666L);
        transaction.commit();
        session.close();


    }
}

@Entity
@OptimisticLocking
class SomeEntity {

    @Version
    private long version;

    @Version
    private Date lastUpdate;

    @Id
    private long id;

    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            Configuration config = new Configuration()
                    .configure(new File(com.o2m.dto.HibernateUtil.class
                            .getClassLoader()
                            .getResource("hibernate.cfg-states.xml")
                            .getFile()));
            return config.buildSessionFactory();

        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
}
