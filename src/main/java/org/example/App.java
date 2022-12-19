package org.example;

import org.example.model.*;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).
                addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Person person = session.get(Person.class, 1);
            System.out.println("Get a person");

            session.getTransaction().commit();
            //session close
            System.out.println("Out of session");

            //open session and transaction again (can do anywhere in code)
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            System.out.println("In second transaction");

            person = (Person) session.merge(person);
            Hibernate.initialize(person.getItems());

            session.getTransaction().commit();

            System.out.println("Out of second session");

            System.out.println(person.getItems());


        }

    }
}
