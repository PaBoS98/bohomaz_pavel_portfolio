package com.o2m;

import com.o2m.dto.HibernateUtil;
import com.o2m.entity.Person;
import com.o2m.entity.Product;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

public class One2ManyMain {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Product p1 = new Product();
        p1.setId(1);
        p1.setName("mask");
        p1.setPrice(8);

        Product p2 = new Product();
        p1.setId(2);
        p1.setName("pizza");
        p1.setPrice(12);

        Set<Product> s = new HashSet<>();
        s.add(p1);
        s.add(p2);

        Person h = new Person();
        h.setId(1);
        h.setFullName("Human");
        h.setProduct(s);
        session.save(h);

        session.beginTransaction().commit();
        HibernateUtil.shutdown();

    }
}
