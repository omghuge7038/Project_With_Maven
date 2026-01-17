package com.sqlquery;

import com.tut.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class SqlExample {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session s = factory.openSession();

        //Sql query
        String q = "select * from student";

        NativeQuery nq = s.createSQLQuery(q);

        List<Object[]> list = nq.list();

        for (Object[] student : list) {
            System.out.println(student[4] + " : " + student[3]);


            s.close();
            factory.close();
        }
    }
}
