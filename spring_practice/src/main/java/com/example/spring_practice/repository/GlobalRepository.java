package com.example.spring_practice.repository;

import com.example.spring_practice.entity.Activity;
import com.example.spring_practice.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class GlobalRepository {

    private final SessionFactory sessionFactory;

    public GlobalRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Person> findAllPerson() {
        Session session = sessionFactory.getCurrentSession();
        System.out.println(session.getTransaction());
        TypedQuery<Person> query = session.createQuery("SELECT p FROM Person p", Person.class);
        return query.getResultList();
    }

    public List<Activity> findAllActivity() {
        Session session = sessionFactory.getCurrentSession();
        System.out.println(session.getTransaction());
        TypedQuery<Activity> query = session.createQuery("SELECT a FROM Activity a", Activity.class);
        return query.getResultList();
    }
}
