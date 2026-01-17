package com.cascade;

import com.map.Answer;
import com.map.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Cascadeaexample {
    public static void main(String[] args) {

        SessionFactory factory= new Configuration().configure().buildSessionFactory();
        Session s=factory.openSession();

        Question q1=new Question();
        q1.setQuestionId(567);
        q1.setQuestion("What is cascading....");

      Answer a1=  new Answer(23423, "In the hibernate it is the imortant concept",q1);
      Answer a2= new Answer(255, "Second answer",q1);
      Answer a3= new Answer(23, "Third answer",q1);
        List<Answer> list=new ArrayList<>();
        list.add(a1);
        list.add(a2);
        list.add(a3);

        q1.setAnswers(list);
        Transaction tx= s.beginTransaction();
        s.save(q1);
        s.save(a1);
        s.save(a2);
        s.save(a3);

        tx.commit();



        s.close();
        factory.close();
    }
}
