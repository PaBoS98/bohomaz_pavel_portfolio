package com.o2o;

import com.o2o.dto.HibernateUtil;
import com.o2o.entity.Person;
import com.o2o.entity.Product;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class One2OneMain {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

//        Product p = new Product();
//        p.setId(1);
//        p.setName("new");
//        p.setPrice(12);
////        session.save(p);
//
//        Person h = new Person();
//        h.setId(4);
//        h.setFullName("Yes?");
//        h.setProduct(p);
////        h.setProduct(1);
//        session.save(h);

        Query q = session.createQuery("From Person ");

        List<Person> resultList = q.list();

        resultList.forEach(System.out::println);

        session.getTransaction().commit();
        session.close();
    }
}
