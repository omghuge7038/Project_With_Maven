package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class MapDemo {
    public static void main(String[] args) {

        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();



         //Creating question
        Question q1 = new Question();
        q1.setQuestionId(12199);
        q1.setQuestion("what is java");

        //Creating answer
        Answer answer = new Answer();
        answer.setAnswerId(343);
        answer.setAnswer("Java is a programming language");
        answer.setQuestion(q1);


        Answer answer1 = new Answer();
        answer1.setAnswerId(33);
        answer1.setAnswer("With the help of java we can create softwares");
        answer1.setQuestion(q1);

        Answer answer2 = new Answer();
        answer2.setAnswerId(34);
        answer2.setAnswer("Java has different type of framework");
        answer2.setQuestion(q1);

        List<Answer> list=new ArrayList<>();
        list.add(answer);
        list.add(answer1);
        list.add(answer2);

        q1.setAnswers(list);





      /*  //Creating question
        Question q2 = new Question();
        q2.setQuestionId(242);
        q2.setQuestion("What is collection framework");

        //Creating answer
        Answer answer1 = new Answer();
        answer1.setAnswerId(344);
        answer1.setAnswer("API to work with java");
        q2.setAnswer(answer1);*/

        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();

       // s.save(q1);// Answer auto-saved because of CASCADE
       Question q= (Question) s.get(Question.class,1212) ;

        tx.commit();
        s.close();
        factory.close();
    }
}
