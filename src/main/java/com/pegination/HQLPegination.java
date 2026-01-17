package com.pegination;

import com.tut.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HQLPegination {
    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        Session s = factory.openSession();

        Query query = s.createQuery("from Student");

        // Implementing pegination using hibernate

        query.setFirstResult(10);

        query.setMaxResults(7);

        List<Student> list=query.list();

        for (Student st:list)
        {
            System.out.println(st.getId()+" : "+st.getName() + " : " + st.getCity());
        }







        s.close();
        factory.close();
    }
}
