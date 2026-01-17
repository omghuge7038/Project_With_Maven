package com.map.xml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {

        //  Load Hibernate configuration
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        // Open session
        Session session = factory.openSession();

        // Begin transaction
        Transaction tx = session.beginTransaction();

        // Create Person object
        Person person = new Person(23, "Om", "Delhi", "52524");

        //  Save Person object
        session.save(person);

        // Commit transaction
        tx.commit();

        // Close session and factory
        session.close();
        factory.close();

        System.out.println("Person saved successfully!");
    }
}
