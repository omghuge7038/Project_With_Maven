package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class App {
    public static void main(String[] args) throws IOException {

        System.out.println("Project started!");

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml"); // Make sure this file is in your classpath
        SessionFactory factory = cfg.buildSessionFactory();

        //creating student
        Student st = new Student();
        st.setId(103);
        st.setName("John");
        st.setCity("Delhi");
        System.out.println(st);

        //Creating class of address class
        Address ad = new Address();
        ad.setStreet("street2");
        ad.setCity("kanpur");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(1234.234);

        //Reading Image
        FileInputStream fls= new FileInputStream("src/main/java/virat.jpg");
        byte[] data=new byte[fls.available()];
        fls.read(data);
        ad.setImage(data);

      Session session= factory.openSession();

      Transaction tx = session.beginTransaction();

      session.save(st);
      session.save(ad);

     // session.getTransaction().commit();


        tx.commit();

      session.close();
        System.out.println("Done..!");

    }
}
