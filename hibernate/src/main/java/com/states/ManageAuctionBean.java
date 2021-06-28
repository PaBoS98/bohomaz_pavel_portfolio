package com.states;


import org.hibernate.Session;

import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
@Stateful
class TransactionBean{

    void method1(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.load();
    }

    void method2() {

    }
}
