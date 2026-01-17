package com.secondcache;

import com.tut.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class SecondCacheExample {
    public static void main(String[] args) {




        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session session1 = factory.openSession();
        //firest
        Student student1=session1.get(Student.class,17);
        System.out.println(student1);

        session1.close();

        Session session2= factory.openSession();
        //Second
        Student student2=session2.get(Student.class,17);
        System.out.println(student2);
        session2.close();

    }
}
