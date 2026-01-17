package com.com.hql;

import com.tut.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HQLExample {

    public static void main(String[] args) {

        // Hibernate configuration
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        // -------------------- SELECT QUERY --------------------
        String hql = "from Student s where s.city = :city and s.name = :name";
        Query query = session.createQuery(hql);
        query.setParameter("city", "Lucknow");
        query.setParameter("name", "Peter");

        List<Student> students = query.list();

        for (Student s : students) {
            System.out.println(s.getName() + " : " + s.getCerti());
        }

        System.out.println("----------------------------------");

        // -------------------- UPDATE QUERY --------------------
        Transaction tx = session.beginTransaction();

        Query updateQuery = session.createQuery(
                "update Student s set s.city = :city where s.name = :name"
        );
        updateQuery.setParameter("city", "Delhi");
        updateQuery.setParameter("name", "Peter");

        int result = updateQuery.executeUpdate();
        System.out.println(result + " objects updated");

        tx.commit();

        // Closing resources
        session.close();
        factory.close();
    }
}
